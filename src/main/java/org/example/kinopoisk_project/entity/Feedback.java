package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;
import sun.awt.SunHints;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "id_feedback")))
public class Feedback extends EntityBase{

    @Column(name = "text")
    private String text;

//  Связь много комментариев - один пользователь
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User userFeedback;

//  Связь много отзывов - один фильм
    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film filmFeedback;
}
