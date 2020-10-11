package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long>{
    Optional<Film> findById(Long id);
}