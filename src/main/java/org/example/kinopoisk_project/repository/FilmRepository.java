package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.Actor;
import org.example.kinopoisk_project.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FilmRepository extends CrudRepository<Film, Long>{
    Optional<Film> findById(Long id);
//    Возвращает все фильмы с указанным актером
    List<Film> findFilmByActorListContains(Actor actor);

    Optional<Film> findByMovieTitle(String movieTitle);
}
