package org.example.kinopoisk_project.converters;

import org.example.kinopoisk_project.dto.FeedbackDto;
import org.example.kinopoisk_project.entity.Feedback;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FeedbackToFeedbackDtoConverter implements Converter<Feedback, FeedbackDto> {
    @Override
    public FeedbackDto convert(Feedback feedback) {
        return FeedbackDto.builder().id(feedback.getId())
                .userNickname(feedback.getUserFeedback().getNickname())
                .movieTitle(feedback.getFilmFeedback().getMovieTitle())
                .text(feedback.getText())
                .build();
    }
}
