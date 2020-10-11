package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;
import sun.awt.SunHints;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "id_feedback")))
public class Feedback extends EntityBase{
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_film")
    private Integer idFilm;

    @Column(name = "text")
    private String text;
}
