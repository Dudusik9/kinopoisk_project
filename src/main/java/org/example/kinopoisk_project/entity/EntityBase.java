package org.example.kinopoisk_project.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class EntityBase {
    @Id
    @GeneratedValue
    private Long id;
}
