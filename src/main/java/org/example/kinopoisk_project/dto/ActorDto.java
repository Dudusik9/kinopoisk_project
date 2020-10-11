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


    private Long id;

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("second_name")
    private String second_name;

    @JsonProperty("year_of_birth")
    private int year_of_birth;
}
