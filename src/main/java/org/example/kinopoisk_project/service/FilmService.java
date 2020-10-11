package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.FilmDto;

public interface FilmService {
    FilmDto getFilmById(Long id);
    FilmDto addNewFilm(FilmDto userDto);
    FilmDto updateFilm(FilmDto userDto);
    void deleteFilm(Long id);
}
