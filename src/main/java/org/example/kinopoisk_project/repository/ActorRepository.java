package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    Optional<Actor> findById(Long id);
}
