package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.Feedback;
import org.example.kinopoisk_project.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
public interface FeedbackRepository extends CrudRepository<Feedback, Long>, PagingAndSortingRepository<Feedback, Long> {

    Optional<Feedback> findById(Long id);

    Collection<Feedback> findAllByUserFeedback (User userFeedback);

//    Page<Feedback> findAll(Pageable pageable);
    Collection<Feedback> findAll();
}
