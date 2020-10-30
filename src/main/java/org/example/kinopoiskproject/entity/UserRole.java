package org.example.kinopoiskproject.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
public class UserRole {
    @Id
    @Column(name = "id_role")
    private Long id;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "userRole", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> user;
}
