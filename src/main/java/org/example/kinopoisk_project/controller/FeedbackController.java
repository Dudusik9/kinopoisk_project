package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/{id}")
    public FeedbackDto getFeedbackById(@PathVariable("id") Long id){
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping
    public FeedbackDto addNewFeedback(@RequestBody FeedbackDto feedback){
        return feedbackService.addNewFeedback(feedback);
    }

    @PutMapping
    public FeedbackDto updateFeedback(@RequestBody FeedbackDto feedback){
        return feedbackService.updateFeedback(feedback);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable("id") Long id){
        feedbackService.deleteFeedback(id);
        System.out.println("Feedback was deleted");
    }

}
