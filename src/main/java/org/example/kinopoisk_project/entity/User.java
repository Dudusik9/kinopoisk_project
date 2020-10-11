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
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "id_user")))
public class User extends EntityBase{
    @Column(name = "nickname")
    private String nickname;

//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "id_user"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> role;
}
