package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @GetMapping("/{id}")
    public ActorDto getActorById(@PathVariable("id") Long id){
        return actorService.getActorById(id);
    }

    @PostMapping("/get")
    public List<ActorDto> getFilmsByActor(@RequestBody FilmDto filmDto){
        return actorService.findActorsByFilm(filmDto);
    }

    @PostMapping
    public ActorDto addNewActor(@RequestBody ActorDto actor){
        return actorService.addNewActor(actor);
    }

    @PutMapping
    public ActorDto updateActor(@RequestBody ActorDto actor){
        return actorService.updateActor(actor);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable("id") Long id){
        actorService.deleteActor(id);
    }

}
