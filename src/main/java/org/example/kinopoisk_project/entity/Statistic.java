package org.example.kinopoisk_project.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "statistic")
@Getter
@Setter
public class Statistic{
    @Id
    @Column(name = "id_user")
    private Long id;

    @Column(name = "number_of_feedback")
    private Long numberOfFeedback;

    @Column(name = "number_of_visits")
    private Long numberOfVisits;

//  Связь один пользователь - одна статистика
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    //    определяется имя поля для текущей таблицы,
    //    по которому будет создан внешний ключ определяющий отношение один к одному на уровне базы данных
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User userStatistic;

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
