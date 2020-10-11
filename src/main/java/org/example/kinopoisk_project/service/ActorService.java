package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.ActorDto;

public interface ActorService {
    ActorDto getActorById(Long id);
    ActorDto addNewActor(ActorDto actorDto);
    ActorDto updateActor(ActorDto actorDto);
    void deleteActor(Long id);
}

