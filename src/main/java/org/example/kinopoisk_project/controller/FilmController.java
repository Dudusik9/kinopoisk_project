package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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
    @PreAuthorize("hasAuthority('READ')")
    public FilmDto getFilmById(@PathVariable("id") Long id){
        return filmService.getFilmById(id);
    }

    @PostMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public List<FilmDto> getFilmsByActor(@RequestBody ActorDto actorDto){
        return filmService.findFilmsByActor(actorDto);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public FilmDto addNewFilm(@Valid @RequestBody FilmDto film) {
        return filmService.addNewFilm(film);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public FilmDto updateFilm(@Valid @RequestBody FilmDto film){
        return filmService.updateFilm(film);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('WRITE')")
    public void deleteFilm(@PathVariable("id") Long id){
        filmService.deleteFilm(id);
    }


    @PostMapping("/{id}/uploadPhoto")
    @PreAuthorize("hasAuthority('WRITE')")
    public void singleFileUpload(@PathVariable("id") long id, @RequestParam("file") MultipartFile file){
        filmService.uploadFile(id, file);
    }

    @GetMapping("/{id}/downloadPhoto")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<byte[]> singleFileDownload(@PathVariable("id") long id) {
        return filmService.downloadFile(id);
    }
}
