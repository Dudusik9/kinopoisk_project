package org.example.kinopoisk_project.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    private Long id;
    private String movie_title;
    private int year;
}
