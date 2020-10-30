package org.example.kinopoiskproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinopoiskproject.validator.Year;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    @JsonProperty("film_id")
    private Long id;

    @NotNull
    @JsonProperty("movie_title")
    private String movieTitle;

    @Year
    @JsonProperty("year")
    private int year;
}
