package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import java.util.List;

public interface ActorService {
    ActorDto getActorById(Long id);
    ActorDto addNewActor(ActorDto actorDto);
    ActorDto updateActor(ActorDto actorDto);
    void deleteActor(Long id);
    List<ActorDto> findActorsByFilm(FilmDto filmDto);
}


