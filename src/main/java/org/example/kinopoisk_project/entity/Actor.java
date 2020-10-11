package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

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
}
