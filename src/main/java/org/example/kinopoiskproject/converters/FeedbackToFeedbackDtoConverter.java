package org.example.kinopoiskproject.converters;

import org.example.kinopoiskproject.dto.FeedbackDto;
import org.example.kinopoiskproject.entity.Feedback;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class FeedbackToFeedbackDtoConverter implements Converter<Feedback, FeedbackDto> {
    @Override
    public FeedbackDto convert(Feedback feedback) {
        return FeedbackDto.builder().id(feedback.getId())
                .userNickname(feedback.getUserFeedback().getNickname())
                .movieTitle(feedback.getFilmFeedback().getMovieTitle())
                .text(feedback.getText())
                .dateOfCreation(feedback.getCreateDate())
                .lastUpdate(feedback.getUpdateDate())
                .usersLike(feedback.getUserSet().stream().map(user -> user.getNickname()).collect(Collectors.toSet()))
                .build();
    }
}
