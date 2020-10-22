package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.Actor;
import org.example.kinopoisk_project.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    Optional<Actor> findById(Long id);
//  Возвращает всех актеров в переданном фильме
    List<Actor> findActorByFilmListContains(Film film);

}
