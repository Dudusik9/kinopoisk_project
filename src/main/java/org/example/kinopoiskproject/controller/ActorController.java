package org.example.kinopoiskproject.controller;

import org.example.kinopoiskproject.dto.ActorDto;
import org.example.kinopoiskproject.dto.FilmDto;
import org.example.kinopoiskproject.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ActorDto getActorById(@PathVariable("id") Long id){
        return actorService.getActorById(id);
    }

    @PostMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public List<ActorDto> getFilmsByActor(@RequestBody FilmDto filmDto){
        return actorService.findActorsByFilm(filmDto);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public ActorDto addNewActor(@Valid @RequestBody ActorDto actor){
        return actorService.addNewActor(actor);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public ActorDto updateActor(@Valid @RequestBody ActorDto actor){
        return actorService.updateActor(actor);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('WRITE')")
    public void deleteActor(@PathVariable("id") Long id){
        actorService.deleteActor(id);
    }

    @PostMapping("/{id}/uploadPhoto")
    @PreAuthorize("hasAuthority('WRITE')")
    public void singleFileUpload(@PathVariable("id") long id, @RequestParam("file")MultipartFile file){
        actorService.uploadFile(id, file);
    }

    @GetMapping("/{id}/downloadPhoto")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<byte[]> singleFileDownload(@PathVariable("id") long id) {
        return actorService.downloadFile(id);
    }

}
