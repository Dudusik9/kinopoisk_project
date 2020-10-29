package org.example.kinopoisk_project.converters;

import org.example.kinopoisk_project.dto.UserDto;
import org.example.kinopoisk_project.entity.User;
import org.example.kinopoisk_project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {
    private final RoleRepository roleRepository;

    @Autowired
    public UserDtoToUserConverter(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setNickname(userDto.getNickname());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setUserRole(roleRepository.findById(userDto.getIdRole()).orElseThrow(() ->  new IllegalArgumentException("Actor didn't find")));
        return user;
    }
}
