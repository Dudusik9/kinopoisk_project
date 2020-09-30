package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("film")
public class FilmController {

    @GetMapping
    public FilmDto getFilmById(@PathVariable("id") Long id){
        return new FilmDto();
    }

    @PostMapping
    public FilmDto saveFilm (@RequestBody FilmDto film){
        return film;
    }

    @PutMapping
    public FilmDto updateFilm(@RequestBody FilmDto film){
        return film;
    }

    @DeleteMapping
    public void deleteFilm(){
        System.out.println("Film was deleted");
    }
}
