package org.example.kinopoiskproject.service.Impl;

import org.example.kinopoiskproject.dto.FeedbackDto;
import org.example.kinopoiskproject.entity.Feedback;
import org.example.kinopoiskproject.repository.FeedbackRepository;
import org.example.kinopoiskproject.repository.FilmRepository;
import org.example.kinopoiskproject.repository.UserRepository;
import org.example.kinopoiskproject.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    private final ConversionService conversionService;


    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, UserRepository userRepository, FilmRepository filmRepository, ConversionService conversionService) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Collection<FeedbackDto> getAllFeedback(Pageable pageable) {

        return feedbackRepository.findAll(pageable)
                .stream()
                .map(feedback -> conversionService.convert(feedback, FeedbackDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<FeedbackDto> getAllFeedbackByUserId(Long id, Pageable pageable) {
        return feedbackRepository.
                findAllByUserFeedback(userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User didn't find")), pageable)
                .stream()
                .map(feedback -> conversionService.convert(feedback, FeedbackDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackDto getFeedbackById(Long id) {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Feedback didn't find"));
        return conversionService.convert(feedback, FeedbackDto.class);
    }


    @Override
    public FeedbackDto addNewFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = conversionService.convert(feedbackDto, Feedback.class);
        feedback.setCreateDate(LocalDateTime.now());
        feedback = feedbackRepository.save(feedback);
        return conversionService.convert(feedback, FeedbackDto.class);
    }

    @Override
    public FeedbackDto updateFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = feedbackRepository.findById(feedbackDto.getId()).orElseThrow(() -> new IllegalArgumentException("Feedback didn't find"));
        feedback.setId(feedbackDto.getId());
        feedback.setUserFeedback(userRepository.findByNickname(feedbackDto.getUserNickname()).orElseThrow(() -> new IllegalArgumentException("User didn't find")));
        feedback.setFilmFeedback(filmRepository.findByMovieTitle(feedbackDto.getMovieTitle()).orElseThrow(() -> new IllegalArgumentException("Film didn't find")));
        feedback.setText(feedbackDto.getText());
        feedback.setUpdateDate(LocalDateTime.now());
        feedback = feedbackRepository.save(feedback);
        return conversionService.convert(feedback, FeedbackDto.class);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
