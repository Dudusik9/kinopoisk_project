package org.example.kinopoiskproject.controller;

import org.example.kinopoiskproject.dto.FeedbackDto;
import org.example.kinopoiskproject.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public FeedbackDto getFeedbackById(@PathVariable("id") Long id){
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public FeedbackDto addNewFeedback(@RequestBody FeedbackDto feedback){
        return feedbackService.addNewFeedback(feedback);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public FeedbackDto updateFeedback(@RequestBody FeedbackDto feedback){
        return feedbackService.updateFeedback(feedback);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('WRITE')")
    public void deleteFeedback(@PathVariable("id") Long id){
        feedbackService.deleteFeedback(id);
    }

    // Получение отзывов по id
    @GetMapping("{id}/feedbacks")
    @PreAuthorize("hasAuthority('READ')")
    public Collection<FeedbackDto> getFeedbacksByUserId(@PathVariable ("id") Long id
            ,@PageableDefault(direction = Sort.Direction.ASC) Pageable pageable){
        return feedbackService.getAllFeedbackByUserId(id, pageable);
    }

    // Pagination
    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    public Collection<FeedbackDto> getAllFeedback(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return feedbackService.getAllFeedback(pageable);
    }
}