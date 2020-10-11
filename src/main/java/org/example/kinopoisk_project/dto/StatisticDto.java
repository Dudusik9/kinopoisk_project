package org.example.kinopoisk_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDto {
    @JsonProperty("id_user")
    private Long id;

    @JsonProperty("number_of_feedback")
    private Long numberOfFeedback;

    @JsonProperty("number_of_visits")
    private Long numberOfVisits;
}
