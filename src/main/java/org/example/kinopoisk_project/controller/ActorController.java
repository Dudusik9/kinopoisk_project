package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read')")
    public ActorDto getActorById(@PathVariable("id") Long id){
        return actorService.getActorById(id);
    }

    @PostMapping("/get")
    @PreAuthorize("hasAuthority('read')")
    public List<ActorDto> getFilmsByActor(@RequestBody FilmDto filmDto){
        return actorService.findActorsByFilm(filmDto);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    public ActorDto addNewActor(@RequestBody ActorDto actor){
        return actorService.addNewActor(actor);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('write')")
    public ActorDto updateActor(@RequestBody ActorDto actor){
        return actorService.updateActor(actor);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void deleteActor(@PathVariable("id") Long id){
        actorService.deleteActor(id);
    }

}
