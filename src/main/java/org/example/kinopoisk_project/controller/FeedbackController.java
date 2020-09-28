package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.dto.UserDto;
import org.example.kinopoisk_project.entity.Feedback;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    @GetMapping
    public FeedbackDto getFeedbcak(){
        return new FeedbackDto();
    }

    @PostMapping
    public Feedback saveFeedback(@RequestBody Feedback feedback){
        return feedback;
    }

    @PutMapping
    public Feedback updateFeedback(@RequestBody Feedback feedback){
        return feedback;
    }

    @DeleteMapping
    public void deleteFeedback(){
        System.out.println("Feedback was deleted");
    }

}
