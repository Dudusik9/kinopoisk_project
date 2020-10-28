package org.example.kinopoisk_project.repository;

import org.example.kinopoisk_project.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<UserRole, Long> {

}
