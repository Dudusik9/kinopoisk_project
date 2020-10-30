package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "id_feedback")))
public class Feedback extends EntityBase{

    @Column(name = "text")
    private String text;

    @CreatedDate()
    @Column(name = "date_of_creation")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "last_update")
    private LocalDateTime updateDate;


//  Связь много комментариев - один пользователь
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User userFeedback;

//  Связь много отзывов - один фильм
    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film filmFeedback;
}
