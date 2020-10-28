package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FeedbackRepository extends CrudRepository<Feedback, Long>, PagingAndSortingRepository<Feedback, Long> {

    Optional<Feedback> findById(Long id);

//    List<Feedback> findAllByUserFeedback(Long id, Pageable pageable);


}
