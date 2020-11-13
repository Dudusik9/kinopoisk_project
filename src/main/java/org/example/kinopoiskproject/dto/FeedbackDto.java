package org.example.kinopoiskproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {
    @NotNull
    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("user")
    private String userNickname;

    @NotNull
    @JsonProperty("movie")
    private String movieTitle;

    @NotEmpty
    @JsonProperty("text")
    private String text;

    @JsonProperty("date_of_creation")
    private LocalDateTime dateOfCreation;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @JsonProperty("users_like")
    private Set<String> usersLike;
}
