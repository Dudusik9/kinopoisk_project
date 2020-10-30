package org.example.kinopoiskproject.repository;

import org.example.kinopoiskproject.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<UserRole, Long> {

}
