package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.Statistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Long> {
    Optional<Statistic> findById(Long id);
}
