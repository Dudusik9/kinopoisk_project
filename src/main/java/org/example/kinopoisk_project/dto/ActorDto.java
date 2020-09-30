package org.example.kinopoisk_project.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto {
    private Long id;
    private String first_name;
    private String second_name;
    private int year_of_birth;
}
