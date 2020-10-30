package org.example.kinopoiskproject.repository;

import org.example.kinopoiskproject.entity.Actor;
import org.example.kinopoiskproject.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FilmRepository extends CrudRepository<Film, Long>{
    Optional<Film> findById(Long id);

    List<Film> findFilmByActorListContains(Actor actor);

    Optional<Film> findByMovieTitle(String movieTitle);
}
