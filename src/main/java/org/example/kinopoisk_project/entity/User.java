package org.example.kinopoisk_project.entity;


import org.example.kinopoisk_project.model.Role;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
