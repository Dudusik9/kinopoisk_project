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
public class FeedbackDto {
    @JsonProperty("id_feedback")
    private Long id;

    @JsonProperty("id_user")
    private Integer idUser;

    @JsonProperty("id_film")
    private Integer idFilm;

    @JsonProperty("text")
    private String text;
}
