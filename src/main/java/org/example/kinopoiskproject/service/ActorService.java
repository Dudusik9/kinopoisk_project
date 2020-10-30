package org.example.kinopoiskproject.service;

import org.example.kinopoiskproject.dto.ActorDto;
import org.example.kinopoiskproject.dto.FilmDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ActorService {
    ActorDto getActorById(Long id);
    ActorDto addNewActor(ActorDto actorDto);
    ActorDto updateActor(ActorDto actorDto);
    void deleteActor(Long id);
    List<ActorDto> findActorsByFilm(FilmDto filmDto);
    String uploadFile(Long id, MultipartFile file);
    ResponseEntity<byte[]> downloadFile(Long id);
}


