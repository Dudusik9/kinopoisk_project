package org.example.kinopoiskproject.service;

import org.example.kinopoiskproject.dto.FeedbackDto;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface FeedbackService {
    Collection<FeedbackDto> getAllFeedback(Pageable pageable);
    Collection<FeedbackDto> getAllFeedbackByUserId(Long id, Pageable pageable);
    FeedbackDto getFeedbackById(Long id);
    FeedbackDto addNewFeedback (FeedbackDto feedbackDto);
    FeedbackDto updateFeedback(FeedbackDto feedbackDto);
    void deleteFeedback (Long id);
}
