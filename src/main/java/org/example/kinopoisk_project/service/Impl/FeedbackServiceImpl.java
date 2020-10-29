package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.entity.Feedback;
import org.example.kinopoisk_project.repository.FeedbackRepository;
import org.example.kinopoisk_project.repository.FilmRepository;
import org.example.kinopoisk_project.repository.UserRepository;
import org.example.kinopoisk_project.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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

//    @Override
//    public Collection<FeedbackDto> getAllFeedbackByUserId(Long id) {
//        return feedbackRepository.
//                findAllByUserFeedback(userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User didn't find")))
//                .stream()
//                .map(feedback -> conversionService.convert(feedback, FeedbackDto.class))
//                .collect(Collectors.toList());
//    }

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
        feedback = feedbackRepository.save(feedback);
        return conversionService.convert(feedback, FeedbackDto.class);
    }

    @Override
    public FeedbackDto updateFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = feedbackRepository.findById(feedbackDto.getId()).orElseThrow(() -> new IllegalArgumentException("Feedback didn't find"));
        feedback.setId(feedbackDto.getId());
        feedback.setUserFeedback(userRepository.findById(feedbackDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User didn't find")));
        feedback.setFilmFeedback(filmRepository.findById(feedbackDto.getFilmId()).orElseThrow(() -> new IllegalArgumentException("Film didn't find")));
        feedback.setText(feedbackDto.getText());
        feedback = feedbackRepository.save(feedback);
        return conversionService.convert(feedback, FeedbackDto.class);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
