package org.example.kinopoiskproject.converters;

import org.example.kinopoiskproject.dto.FeedbackDto;
import org.example.kinopoiskproject.entity.Feedback;
import org.example.kinopoiskproject.entity.Film;
import org.example.kinopoiskproject.entity.User;
import org.example.kinopoiskproject.repository.FilmRepository;
import org.example.kinopoiskproject.repository.UserRepository;
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
        feedback.setUserFeedback(covertUserNicknameToUser(feedbackDto));
        feedback.setFilmFeedback(convertMoverTitleByFilm(feedbackDto));
        feedback.setText(feedbackDto.getText());
        return feedback;
    }

    private User covertUserNicknameToUser(FeedbackDto feedbackDto){
        return userRepository.findByNickname(feedbackDto.getUserNickname()).orElseThrow(() -> new IllegalArgumentException("User didn't find"));
    }

    private Film convertMoverTitleByFilm(FeedbackDto feedbackDto){
        return filmRepository.findByMovieTitle(feedbackDto.getMovieTitle()).orElseThrow(() -> new IllegalArgumentException("Film didn't find"));
    }
}

