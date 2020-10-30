package org.example.kinopoiskproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
