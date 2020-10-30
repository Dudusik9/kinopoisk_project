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
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user")
    private String userNickname;

    @JsonProperty("movie")
    private String movieTitle;

    @JsonProperty("text")
    private String text;

    @JsonProperty("date_of_creation")
    private LocalDateTime dateOfCreation;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;
}
