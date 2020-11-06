package org.example.kinopoiskproject.converters;

import org.example.kinopoiskproject.dto.StatisticDto;
import org.example.kinopoiskproject.entity.Statistic;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StatisticToStatisticDtoConverter implements Converter<Statistic, StatisticDto> {

    @Override
    public StatisticDto convert(Statistic statistic) {
        return StatisticDto.builder()
                .id(statistic.getId())
                .numberOfFeedback(statistic.getNumberOfFeedback())
                .numberOfVisits(statistic.getNumberOfVisits())
                .build();
    }
}
