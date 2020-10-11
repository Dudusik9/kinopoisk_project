package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "films")
@Getter
@Setter
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "id_film")))
public class Film extends EntityBase{
    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "year")
    private Integer year;
}
