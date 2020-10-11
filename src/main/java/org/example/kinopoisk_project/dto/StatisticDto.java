package org.example.kinopoisk_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDto {
    @JsonProperty("userId")
    private Long id;

    @JsonProperty("numberOfFeedback")
    private Long numberOfFeedback;

    @JsonProperty("numberOfVisits")
    private Long numberOfVisits;
}
