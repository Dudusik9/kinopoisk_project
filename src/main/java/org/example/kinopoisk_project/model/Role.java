package org.example.kinopoisk_project.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Role {
    GUEST(Stream.of(Permission.READ).collect(Collectors.toSet())),
    ADMIN(Stream.of(Permission.READ, Permission.STATISTIC_READ, Permission.WRITE).collect(Collectors.toSet()));

    private final Set<Permission> permissions;

// Набор Authorities для каждой роли
    Role(Set<Permission> permissions) {
        this.permissions = permissions;

    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

//    Конвертим Authorities в SimpleGrantedAuthorities
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }


}
