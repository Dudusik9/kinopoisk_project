package org.example.kinopoiskproject.converters;

import org.example.kinopoiskproject.dto.ActorDto;
import org.example.kinopoiskproject.entity.Actor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActorDtoToActorConverter implements Converter<ActorDto, Actor> {

    @Override
    public Actor convert(ActorDto actorDto) {
        Actor actor = new Actor();
        actor.setId(actorDto.getId());
        actor.setFirstName(actorDto.getFirstName());
        actor.setSecondName(actorDto.getSecondName());
        actor.setYearOfBirth(actorDto.getYearOfBirth());
        return actor;
    }
}
