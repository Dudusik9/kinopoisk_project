package org.example.kinopoisk_project.entity;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "id_role"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> role;

//  Связь один пользователь - много комментариев
    @OneToMany(mappedBy = "userFeedback", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Feedback> feedbackList = new ArrayList<>();

// Связь один пользователь - одна статистика
    @OneToOne(mappedBy = "userStatistic")
    private Statistic statistic;

//    Связь много пользователей - одна роль
    @ManyToOne
    @JoinColumn(name = "id_user_role")
    private UserRole userRole;

}
