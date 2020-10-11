package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.entity.Feedback;
import org.example.kinopoisk_project.repository.FeedbackRepository;
import org.example.kinopoisk_project.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public FeedbackDto getFeedbackById(Long id) {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Feedback didn't find"));
        return FeedbackDto.builder().id(feedback.getId())
                .idUser(feedback.getIdUser())
                .idFilm(feedback.getIdFilm())
                .text(feedback.getText())
                .build();
    }

    @Override
    public FeedbackDto addNewFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setIdUser(feedbackDto.getIdUser());
        feedback.setIdFilm(feedbackDto.getIdFilm());
        feedback.setText(feedbackDto.getText());
        feedback = feedbackRepository.save(feedback);
        return FeedbackDto.builder().id(feedback.getId())
                .idUser(feedback.getIdUser())
                .idFilm(feedback.getIdFilm())
                .text(feedback.getText())
                .build();
    }

    @Override
    public FeedbackDto updateFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = feedbackRepository.findById(feedbackDto.getId()).orElseThrow(() -> new IllegalArgumentException("Feedback didn't find"));
        feedback.setText(feedbackDto.getText());
        feedback = feedbackRepository.save(feedback);
        return FeedbackDto.builder().id(feedback.getId())
                .idUser(feedback.getIdUser())
                .idFilm(feedback.getIdFilm())
                .text(feedback.getText())
                .build();
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
