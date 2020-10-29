package org.example.kinopoisk_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.PositiveOrZero;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDto {
    @JsonProperty("user_id")
    private Long id;

    @PositiveOrZero
    @JsonProperty("number_of_feedback")
    private Long numberOfFeedback;

    @PositiveOrZero
    @JsonProperty("number_of_visits")
    private Long numberOfVisits;
}
