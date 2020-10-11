package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "statistic")
@Getter
@Setter
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "id_user")))
public class Statistic extends EntityBase{
    @Column(name = "number_of_feedback")
    private Long numberOfFeedback;

    @Column(name = "number_of_visits")
    private Long numberOfVisits;

//  Связь один пользователь - одна статистика
    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User userStatistic;

}
