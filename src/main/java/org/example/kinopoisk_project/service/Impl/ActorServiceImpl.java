package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.entity.Actor;
import org.example.kinopoisk_project.entity.Film;
import org.example.kinopoisk_project.repository.ActorRepository;
import org.example.kinopoisk_project.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public ActorDto getActorById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
        return ActorDto.builder().id(actor.getId())
                .firstName(actor.getFirstName())
                .secondName(actor.getSecondName())
                .yearOfBirth(actor.getYearOfBirth())
                .build();
    }

    @Override
    public List<ActorDto> findActorsByFilm(FilmDto filmDto){
        Film film = new Film();
        film.setId(filmDto.getId());
        film.setMovieTitle(filmDto.getMovieTitle());
        film.setYear(filmDto.getYear());
        List<Actor> actorList = actorRepository.findActorByFilmListContains(film);
        return actorList.stream().map(actor -> ActorDto.builder().id(actor.getId())
                .firstName(actor.getFirstName())
                .secondName(actor.getSecondName())
                .yearOfBirth(actor.getYearOfBirth())
                .build()).collect(Collectors.toList());
    }

    @Override
    public ActorDto addNewActor(ActorDto actorDto) {
        Actor actor = new Actor();
        actor.setFirstName(actorDto.getFirstName());
        actor.setSecondName(actorDto.getSecondName());
        actor.setYearOfBirth(actorDto.getYearOfBirth());
        actor = actorRepository.save(actor);
        return ActorDto.builder().id(actor.getId())
                .firstName(actor.getFirstName())
                .secondName(actor.getSecondName())
                .yearOfBirth(actor.getYearOfBirth())
                .build();
    }

    @Override
    public ActorDto updateActor(ActorDto actorDto) {
        Actor actor = actorRepository.findById(actorDto.getId()).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
        actor.setFirstName(actorDto.getFirstName());
        actor.setSecondName(actorDto.getSecondName());
        actor.setYearOfBirth(actorDto.getYearOfBirth());
        actor = actorRepository.save(actor);
        return ActorDto.builder().id(actor.getId())
                .firstName(actor.getFirstName())
                .secondName(actor.getSecondName())
                .yearOfBirth(actor.getYearOfBirth())
                .build();
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
