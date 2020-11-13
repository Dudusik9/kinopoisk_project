package org.example.kinopoiskproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto{
    @NotNull
    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("nickname")
    private String nickname;

    @NotNull
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("first_name")
    private String firstName;

    @NotNull
    @JsonProperty("last_name")
    private String lastName;

    @NotNull
    @JsonProperty("password")
    private String password;

    @Positive
    @JsonProperty("id_user_role")
    private Long idRole;

    @JsonProperty("left_feedbacks")
    private Set<Long> feedbacksLeft;

    @JsonProperty("like_feedbacks")
    private Set<Long> feedbacksLike;
}
