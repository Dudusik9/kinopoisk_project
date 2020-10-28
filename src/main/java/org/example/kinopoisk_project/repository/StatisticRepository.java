package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.Statistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface StatisticRepository extends CrudRepository<Statistic, Long> {
    Optional<Statistic> findById(Long id);
}
