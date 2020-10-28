package org.example.kinopoisk_project.model;

public enum Permission {

    READ("READ"),
    STATISTIC_READ("STATISTIC_READ"),
    WRITE("WRITE");


    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
