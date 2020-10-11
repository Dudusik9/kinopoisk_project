package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.entity.Film;
import org.example.kinopoisk_project.repository.FilmRepository;
import org.example.kinopoisk_project.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public FilmDto getFilmById(Long id) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Film didn't find"));
        return FilmDto.builder().id(film.getId()).movieTitle(film.getMovieTitle()).year(film.getYear()).build();
    }

    @Override
    public FilmDto addNewFilm(FilmDto filmDto) {
        Film film = new Film();
        film.setId(filmDto.getId());
        film.setMovieTitle(filmDto.getMovieTitle());
        film.setYear(filmDto.getYear());
        film = filmRepository.save(film);
        return FilmDto.builder().id(film.getId()).movieTitle(film.getMovieTitle()).year(film.getYear()).build();
    }

    @Override
    public FilmDto updateFilm(FilmDto filmDto) {
        Film film = filmRepository.findById(filmDto.getId()).orElseThrow(() -> new IllegalArgumentException("Film didn't find"));
        film.setMovieTitle(filmDto.getMovieTitle());
        film.setYear(filmDto.getYear());
        film = filmRepository.save(film);
        return FilmDto.builder().id(film.getId()).movieTitle(film.getMovieTitle()).year(film.getYear()).build();
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }
}
