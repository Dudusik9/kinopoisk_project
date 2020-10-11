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
//    @Column(name = "id_user")
//    private Long idUser;
//
//    @Column(name = "id_film")
//    private Long idFilm;

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
