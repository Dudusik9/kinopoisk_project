package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "films")
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue
    @Column(name = "id_film")
    private Long id;

    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "year")
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
