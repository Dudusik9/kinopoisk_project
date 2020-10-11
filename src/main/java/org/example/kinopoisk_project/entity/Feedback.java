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
public class Feedback {
    @Id
    @GeneratedValue
    @Column(name = "id_feedback")
    private Long id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_film")
    private Integer idFilm;

    @Column(name = "text")
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(id, feedback.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
