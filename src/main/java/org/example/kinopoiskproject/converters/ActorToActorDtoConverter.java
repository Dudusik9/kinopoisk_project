package org.example.kinopoiskproject.converters;

import org.example.kinopoiskproject.dto.ActorDto;
import org.example.kinopoiskproject.entity.Actor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActorToActorDtoConverter implements Converter<Actor, ActorDto> {
    @Override
    public ActorDto convert(Actor actor) {
        return ActorDto.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .secondName(actor.getSecondName())
                .yearOfBirth(actor.getYearOfBirth())
                .build();
    }
}
