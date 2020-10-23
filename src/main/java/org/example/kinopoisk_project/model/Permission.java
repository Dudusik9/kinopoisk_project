package org.example.kinopoisk_project.model;

public enum Permission {

    READ("read"),
    STATISTIC_READ("statisticRead"),
    WRITE("write");


    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
