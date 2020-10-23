package org.example.kinopoisk_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinopoisk_project.model.Role;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

//      Реализовать вывод роли
//    @JsonProperty("role")
//    private String role;
}
