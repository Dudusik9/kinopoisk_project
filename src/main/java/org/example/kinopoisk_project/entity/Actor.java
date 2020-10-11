package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "actors")
@Getter
@Setter
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "id_actor")))
public class Actor extends EntityBase{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "year_of_birth")
    private Integer yearOfBirth;


//    Связь ManyToMaNy. Много актеров - много фильмов
    @ManyToMany
        @JoinTable(
                name = "actors_films",
                joinColumns = @JoinColumn(name = "id_film"),
                inverseJoinColumns = @JoinColumn(name = "id_actor")
        )
    private Set<Film> filmList = new HashSet<>();

}
