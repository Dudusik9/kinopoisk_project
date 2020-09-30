package org.example.kinopoisk_project.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto{
    private Long id;
    private String nickname;
}
