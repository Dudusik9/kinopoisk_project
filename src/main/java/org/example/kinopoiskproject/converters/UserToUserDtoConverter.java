package org.example.kinopoiskproject.converters;

import org.example.kinopoiskproject.dto.UserDto;
import org.example.kinopoiskproject.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        return UserDto.builder().
                id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .idRole(user.getUserRole().getId())
                .build();
    }
}
