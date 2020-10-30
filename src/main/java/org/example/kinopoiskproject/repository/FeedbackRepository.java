package org.example.kinopoiskproject.repository;

import org.example.kinopoiskproject.entity.Feedback;
import org.example.kinopoiskproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FeedbackRepository extends CrudRepository<Feedback, Long>, PagingAndSortingRepository<Feedback, Long> {

    Optional<Feedback> findById(Long id);

    List<Feedback> findAllByUserFeedback(User userFeedback, Pageable pageable);

    Page<Feedback> findAll(Pageable pageable);
}
