package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.entity.Actor;
import org.example.kinopoisk_project.entity.Film;
import org.example.kinopoisk_project.repository.FilmRepository;
import org.example.kinopoisk_project.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final ConversionService conversionService;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository, ConversionService conversionService) {
        this.filmRepository = filmRepository;
        this.conversionService = conversionService;
    }

    @Override
    public FilmDto getFilmById(Long id) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Film didn't find"));
        return conversionService.convert(film, FilmDto.class);
    }

    @Override
    public List<FilmDto> findFilmsByActor(ActorDto actorDto) {
        Actor actor = conversionService.convert(actorDto, Actor.class);
        List<Film> filmList = filmRepository.findFilmByActorListContains(actor);
        return filmList.stream()
                .map(film -> conversionService.convert(film, FilmDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FilmDto addNewFilm(FilmDto filmDto) {
        Film film = conversionService.convert(filmDto, Film.class);
        film = filmRepository.save(film);
        return conversionService.convert(film, FilmDto.class);
    }


    @Override
    public FilmDto updateFilm(FilmDto filmDto) {
        Film film = filmRepository.findById(filmDto.getId()).orElseThrow(() -> new IllegalArgumentException("Film didn't find"));
        film.setMovieTitle(filmDto.getMovieTitle());
        film.setYear(filmDto.getYear());
        film = filmRepository.save(film);
        return conversionService.convert(film, FilmDto.class);
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }
}
