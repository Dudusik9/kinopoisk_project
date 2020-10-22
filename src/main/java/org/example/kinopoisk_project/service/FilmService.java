package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import java.util.List;

public interface FilmService {
    FilmDto getFilmById(Long id);
    FilmDto addNewFilm(FilmDto userDto);
    FilmDto updateFilm(FilmDto userDto);
    void deleteFilm(Long id);
    List<FilmDto> findFilmsByActor(ActorDto ActorDto);
}
