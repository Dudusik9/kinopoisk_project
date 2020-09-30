package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.dto.UserDto;
import org.example.kinopoisk_project.entity.Feedback;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    @GetMapping
    public FeedbackDto getFeedbackById(@PathVariable("id") Long id){
        return new FeedbackDto();
    }

    @PostMapping
    public FeedbackDto saveFeedback(@RequestBody FeedbackDto feedback){
        return feedback;
    }

    @PutMapping
    public FeedbackDto updateFeedback(@RequestBody FeedbackDto feedback){
        return feedback;
    }

    @DeleteMapping
    public void deleteFeedback(){
        System.out.println("Feedback was deleted");
    }

}
