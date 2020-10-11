package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "films")
@Getter
@Setter
public class Films {
    @Id
    @GeneratedValue
    @Column(name = "id_film")
    private Long id;

    @Column(name = "movie_title")
    private String firstName;

    @Column(name = "year")
    private String year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Films films = (Films) o;
        return Objects.equals(id, films.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
