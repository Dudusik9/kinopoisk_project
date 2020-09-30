package org.example.kinopoisk_project.entity;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "movie_title", nullable = false)
    private String firstName;

    @Column(name = "year", nullable = false)
    private String year;
}
