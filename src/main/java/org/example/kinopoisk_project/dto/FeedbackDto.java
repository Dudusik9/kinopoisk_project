package org.example.kinopoisk_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinopoisk_project.entity.Film;
import org.example.kinopoisk_project.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {
    @JsonProperty("id")
    private Long id;


    @JsonProperty("user")
    private Long userId;

    @JsonProperty("film")
    private Long filmId;

    @JsonProperty("text")
    private String text;
}
