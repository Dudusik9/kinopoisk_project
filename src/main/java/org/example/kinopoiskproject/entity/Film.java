package org.example.kinopoiskproject.entity;

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

    @Column(name = "poster")
    private String imagePoster;

//    Связь один фильм - много отзывов
    @OneToMany(mappedBy = "filmFeedback", fetch = FetchType.LAZY)
    private List<Feedback> feedback = new ArrayList<>();

//    Связь ManyToMaNy. Много фильма - много актеров
//    @ManyToMany(mappedBy = "filmList")
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "actors_films",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_actor")
    )
    private Set<Actor> actorList = new HashSet<>();


}
