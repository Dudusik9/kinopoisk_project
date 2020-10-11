package org.example.kinopoisk_project.entity;


import lombok.Getter;
import lombok.Setter;
import org.example.kinopoisk_project.model.Role;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")

public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    @Column(name = "id_user")
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "id_user"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
