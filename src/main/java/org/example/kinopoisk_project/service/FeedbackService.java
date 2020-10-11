package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.FeedbackDto;

public interface FeedbackService {
    FeedbackDto getFeedbackById(Long id);
    FeedbackDto addNewFeedback (FeedbackDto feedbackDto);
    FeedbackDto updateFeedback(FeedbackDto feedbackDto);
    void deleteFeedback (Long id);
}
