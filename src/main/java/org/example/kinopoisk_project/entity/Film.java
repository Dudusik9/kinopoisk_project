package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

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

//    Связь один фильм - много отзывов
    @OneToMany(mappedBy = "filmFeedback", fetch = FetchType.LAZY)
    private List<Feedback> feedback = new ArrayList<>();

//    Связь ManyToMaNy. Много фильма - много актеров
    @ManyToMany(mappedBy = "filmList")
    private Set<Actor> actorList = new HashSet<>();

}