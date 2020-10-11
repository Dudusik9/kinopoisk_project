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
public class ActorDto {
    @JsonProperty("id_actor")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("second_name")
    private String secondName;

    @JsonProperty("year_of_birth")
    private int yearOfBirth;
}
