package org.example.kinopoisk_project.entity;


import lombok.Getter;
import lombok.Setter;
import org.example.kinopoisk_project.model.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "id_user")))
public class User extends EntityBase{
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

// Как замапить так, чтобы писалось не в Set<Role>, а в конкретное поле Role
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "id_role"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

//  Связь один пользователь - много комментариев
    @OneToMany(mappedBy = "userFeedback", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Feedback> feedbackList = new ArrayList<>();

// Связь один пользователь - одна статистика
    @OneToOne(mappedBy = "userStatistic", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Statistic statistic;
}
