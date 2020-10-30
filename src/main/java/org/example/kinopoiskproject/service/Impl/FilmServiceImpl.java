package org.example.kinopoiskproject.service.Impl;

import org.example.kinopoiskproject.dto.ActorDto;
import org.example.kinopoiskproject.dto.FilmDto;
import org.example.kinopoiskproject.entity.Actor;
import org.example.kinopoiskproject.entity.Film;
import org.example.kinopoiskproject.repository.FilmRepository;
import org.example.kinopoiskproject.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class FilmServiceImpl implements FilmService {

    @Value("${repository.films.UPLOADED_FOLDER}")
    private String UPLOADED_FOLDER;

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

    @Override
    public String uploadFile(Long id, MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            Film film = filmRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
            film.setImagePoster(path.toString());
            filmRepository.save(film);
            return "Poster have been upload";
        }
        catch (IOException e){
            e.printStackTrace();
            return "Poster haven't been upload";
        }
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(Long id) {
        try {
            Film film = filmRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Actor didn't find"));
            Path path = Paths.get(film.getImagePoster());
            byte[] byteArrayImage = Files.readAllBytes(path);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(byteArrayImage.length);
            return new ResponseEntity<>(byteArrayImage, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
