package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FilmService {
    FilmDto getFilmById(Long id);
    FilmDto addNewFilm(FilmDto userDto);
    FilmDto updateFilm(FilmDto userDto);
    void deleteFilm(Long id);
    List<FilmDto> findFilmsByActor(ActorDto ActorDto);
    String uploadFile(Long id, MultipartFile file);
    ResponseEntity<byte[]> downloadFile(Long id);
}
