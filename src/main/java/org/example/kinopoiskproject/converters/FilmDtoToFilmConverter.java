package org.example.kinopoiskproject.converters;

import org.example.kinopoiskproject.dto.FilmDto;
import org.example.kinopoiskproject.entity.Film;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FilmDtoToFilmConverter implements Converter<FilmDto, Film> {
    @Override
    public Film convert(FilmDto filmDto) {
        Film film = new Film();
        film.setId(filmDto.getId());
        film.setMovieTitle(filmDto.getMovieTitle());
        film.setYear(filmDto.getYear());
        return film;
    }
}
