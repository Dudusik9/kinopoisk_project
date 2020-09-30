package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
