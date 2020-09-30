package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);
}
