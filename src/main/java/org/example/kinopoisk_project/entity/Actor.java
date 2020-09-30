package org.example.kinopoisk_project.entity;

import javax.persistence.*;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "year_of_birth", nullable = false)
    private String yearOfBirth;
}
