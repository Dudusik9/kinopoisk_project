package org.example.kinopoiskproject.converters;


import org.example.kinopoiskproject.dto.FilmDto;
import org.example.kinopoiskproject.entity.Film;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FilmToFilmDtoConverter implements Converter<Film, FilmDto> {
    @Override
    public FilmDto convert(Film film) {
        return FilmDto.builder().id(film.getId()).movieTitle(film.getMovieTitle()).year(film.getYear()).build();
    }
}
