package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.kinopoisk_project.model.Role;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "statistic")
@Getter
@Setter
public class Statistic {
    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private Long id;

    @Column(name = "number_of_feedback")
    private Long numberOfFeedback;

    @Column(name = "number_of_visits")
    private Long numberOfVisits;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return id.equals(statistic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
