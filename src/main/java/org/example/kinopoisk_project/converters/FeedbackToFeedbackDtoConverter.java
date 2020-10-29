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
                .userId(feedback.getUserFeedback().getId())
                .filmId(feedback.getFilmFeedback().getId())
                .text(feedback.getText())
                .build();
    }
}
