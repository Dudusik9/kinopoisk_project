package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.entity.Feedback;

import java.awt.print.Pageable;
import java.util.List;

public interface FeedbackService {
    FeedbackDto getFeedbackById(Long id);
    List<Feedback> getAllFeedback(Pageable pageable);
    FeedbackDto addNewFeedback (FeedbackDto feedbackDto);
    FeedbackDto updateFeedback(FeedbackDto feedbackDto);
    void deleteFeedback (Long id);
}
