package org.example.kinopoisk_project.service.Impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.example.kinopoisk_project.dto.ActorDto;
import org.example.kinopoisk_project.dto.FilmDto;
import org.example.kinopoisk_project.entity.Actor;
import org.example.kinopoisk_project.entity.Film;
import org.example.kinopoisk_project.repository.ActorRepository;
import org.example.kinopoisk_project.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    private final String UPLOADED_FOLDER = "C:\\Users\\dimad\\Desktop\\JAVA PROJECTS\\Kinopoisk_project\\repository\\Actors_images\\";

    private final ActorRepository actorRepository;
    private final ConversionService conversionService;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, ConversionService conversionService) {
        this.actorRepository = actorRepository;
        this.conversionService = conversionService;
    }

    @Override
    public ActorDto getActorById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
        return conversionService.convert(actor, ActorDto.class);
    }

    @Override
    public List<ActorDto> findActorsByFilm(FilmDto filmDto){
        Film film = conversionService.convert(filmDto, Film.class);
        List<Actor> actorList = actorRepository.findActorByFilmListContains(film);
        return actorList.stream().map(actor -> conversionService.convert(actor, ActorDto.class)).collect(Collectors.toList());
    }

    @Override
    public ActorDto addNewActor(ActorDto actorDto) {
        Actor actor = conversionService.convert(actorDto, Actor.class);
        actor = actorRepository.save(actor);
        return conversionService.convert(actor, ActorDto.class);
    }

    @Override
    public ActorDto updateActor(ActorDto actorDto) {
        Actor actor = actorRepository.findById(actorDto.getId()).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
        actor.setFirstName(actorDto.getFirstName());
        actor.setSecondName(actorDto.getSecondName());
        actor.setYearOfBirth(actorDto.getYearOfBirth());
        actor = actorRepository.save(actor);
        return conversionService.convert(actor, ActorDto.class);
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public String uploadFile(Long id, MultipartFile file) {
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            Actor actor = actorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
            actor.setImage(path.toString());
            actorRepository.save(actor);
            return "File have been upload";
        }
        catch (IOException e){
            e.printStackTrace();
            return "File haven't been upload";
        }
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(Long id) {
        try {
            Actor actor = actorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
            Path path = Paths.get(actor.getImage());
            byte[] byteArrayImage = Files.readAllBytes(path);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(byteArrayImage.length);
            return new ResponseEntity<byte[]>(byteArrayImage, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
