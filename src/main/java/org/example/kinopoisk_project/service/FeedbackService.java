package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface FeedbackService {
    FeedbackDto getFeedbackById(Long id);
    FeedbackDto addNewFeedback (FeedbackDto feedbackDto);
    FeedbackDto updateFeedback(FeedbackDto feedbackDto);
    void deleteFeedback (Long id);

//    Page<Feedback> getAllFeedback(Pageable pageable);
    Collection<FeedbackDto> getAllFeedback();
    Collection<FeedbackDto> getAllFeedbackByUserId(Long id);
}
