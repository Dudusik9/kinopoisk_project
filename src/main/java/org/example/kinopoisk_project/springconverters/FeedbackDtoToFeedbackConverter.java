package org.example.kinopoisk_project.springconverters;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.entity.Feedback;
import org.example.kinopoisk_project.repository.FilmRepository;
import org.example.kinopoisk_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FeedbackDtoToFeedbackConverter implements Converter<FeedbackDto, Feedback> {
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;

    @Autowired
    public FeedbackDtoToFeedbackConverter( UserRepository userRepository, FilmRepository filmRepository) {
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public Feedback convert(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setId(feedbackDto.getId());
        feedback.setUserFeedback(userRepository.findById(feedbackDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User didn't find")));
        feedback.setFilmFeedback(filmRepository.findById(feedbackDto.getFilmId()).orElseThrow(() -> new IllegalArgumentException("Film didn't find")));
        feedback.setText(feedbackDto.getText());
        return feedback;
    }
}
