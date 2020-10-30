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
public class ActorDto {
    @JsonProperty("actor_id")
    private Long id;

    @NotNull
    @JsonProperty("first_name")
    private String firstName;

    @NotNull
    @JsonProperty("second_name")
    private String secondName;

    @Year
    @JsonProperty("year_of_birth")
    private int yearOfBirth;


}
