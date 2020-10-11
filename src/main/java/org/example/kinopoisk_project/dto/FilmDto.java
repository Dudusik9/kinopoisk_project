package org.example.kinopoisk_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    @JsonProperty("filmId")
    private Long id;

    @JsonProperty("movieTitle")
    private String movieTitle;

    @JsonProperty("year")
    private int year;
}
