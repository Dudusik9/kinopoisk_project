package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/{id}")
    public FilmDto getFilmById(@PathVariable("id") Long id){
        return filmService.getFilmById(id);
    }

    @PostMapping
    public FilmDto addNewFilm(@RequestBody FilmDto film) {
        return filmService.addNewFilm(film);
    }

    @PostMapping("/get")
    public List<FilmDto> getFilmsByActor(@RequestBody ActorDto actorDto){
        return filmService.findFilmsByActor(actorDto);
    }

    @PutMapping
    public FilmDto updateFilm(@RequestBody FilmDto film){
        return filmService.updateFilm(film);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable("id") Long id){
        filmService.deleteFilm(id);
    }
}
