package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.entity.Feedback;
import org.example.kinopoisk_project.repository.FeedbackRepository;
import org.example.kinopoisk_project.repository.FilmRepository;
import org.example.kinopoisk_project.repository.UserRepository;
import org.example.kinopoisk_project.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, UserRepository userRepository, FilmRepository filmRepository) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public FeedbackDto getFeedbackById(Long id) {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Feedback didn't find"));
        return FeedbackDto.builder().
                id(feedback.getId())
                .userId(feedback.getUserFeedback().getId())
                .filmId(feedback.getFilmFeedback().getId())
                .text(feedback.getText())
                .build();
    }

    @Override
    public FeedbackDto addNewFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setId(feedbackDto.getId());
        feedback.setUserFeedback(userRepository.findById(feedbackDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User didn't find")));
        feedback.setFilmFeedback(filmRepository.findById(feedbackDto.getFilmId()).orElseThrow(() -> new IllegalArgumentException("Film didn't find")));
        feedback.setText(feedbackDto.getText());
        feedback = feedbackRepository.save(feedback);
        return FeedbackDto.builder().id(feedback.getId())
                .userId(feedback.getUserFeedback().getId())
                .filmId(feedback.getFilmFeedback().getId())
                .text(feedback.getText())
                .build();
    }

    @Override
    public FeedbackDto updateFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = feedbackRepository.findById(feedbackDto.getId()).orElseThrow(() -> new IllegalArgumentException("Feedback didn't find"));
        feedback.setUserFeedback(userRepository.findById(feedbackDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User didn't find")));
        feedback.setFilmFeedback(filmRepository.findById(feedbackDto.getFilmId()).orElseThrow(() -> new IllegalArgumentException("Film didn't find")));
        feedback.setText(feedbackDto.getText());
        feedback = feedbackRepository.save(feedback);
        return FeedbackDto.builder().id(feedback.getId())
                .userId(feedback.getUserFeedback().getId())
                .filmId(feedback.getFilmFeedback().getId())
                .text(feedback.getText())
                .build();
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
