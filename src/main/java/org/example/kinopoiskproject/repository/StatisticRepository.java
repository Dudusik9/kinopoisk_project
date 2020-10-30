package org.example.kinopoiskproject.repository;

import org.example.kinopoiskproject.entity.Statistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface StatisticRepository extends CrudRepository<Statistic, Long> {
    Optional<Statistic> findById(Long id);
}
