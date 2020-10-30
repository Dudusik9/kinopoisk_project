package org.example.kinopoiskproject.repository;

import org.example.kinopoiskproject.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);

    Optional<User> findByNickname(String nickname);

    Optional<User> findByEmail(String email);

    Optional<User>  findByActivationCode(String code);
}
