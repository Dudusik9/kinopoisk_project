package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    Optional<Feedback> findById(Long id);
}
