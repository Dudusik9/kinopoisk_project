package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.entity.Actor;
import org.example.kinopoisk_project.repository.ActorRepository;
import org.example.kinopoisk_project.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
