package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.entity.Actor;
import org.example.kinopoisk_project.entity.Film;
import org.example.kinopoisk_project.repository.ActorRepository;
import org.example.kinopoisk_project.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final ConversionService conversionService;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, ConversionService conversionService) {
        this.actorRepository = actorRepository;
        this.conversionService = conversionService;
    }

    @Override
    public ActorDto getActorById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
        return conversionService.convert(actor, ActorDto.class);
    }

    @Override
    public List<ActorDto> findActorsByFilm(FilmDto filmDto){
        Film film = conversionService.convert(filmDto, Film.class);
        List<Actor> actorList = actorRepository.findActorByFilmListContains(film);
        return actorList.stream().map(actor -> conversionService.convert(actor, ActorDto.class)).collect(Collectors.toList());
    }

    @Override
    public ActorDto addNewActor(ActorDto actorDto) {
        Actor actor = conversionService.convert(actorDto, Actor.class);
        actor = actorRepository.save(actor);
        return conversionService.convert(actor, ActorDto.class);
    }

    @Override
    public ActorDto updateActor(ActorDto actorDto) {
        Actor actor = actorRepository.findById(actorDto.getId()).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
        actor.setFirstName(actorDto.getFirstName());
        actor.setSecondName(actorDto.getSecondName());
        actor.setYearOfBirth(actorDto.getYearOfBirth());
        actor = actorRepository.save(actor);
        return conversionService.convert(actor, ActorDto.class);
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
