package org.example.kinopoisk_project.entity;

import sun.awt.SunHints;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "text", nullable = false)
    private String text;
}
