package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read')")
    public FilmDto getFilmById(@PathVariable("id") Long id){
        return filmService.getFilmById(id);
    }

    @PostMapping("/get")
    @PreAuthorize("hasAuthority('read')")
    public List<FilmDto> getFilmsByActor(@RequestBody ActorDto actorDto){
        return filmService.findFilmsByActor(actorDto);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    public FilmDto addNewFilm(@RequestBody FilmDto film) {
        return filmService.addNewFilm(film);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('write')")
    public FilmDto updateFilm(@RequestBody FilmDto film){
        return filmService.updateFilm(film);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void deleteFilm(@PathVariable("id") Long id){
        filmService.deleteFilm(id);
    }
}
