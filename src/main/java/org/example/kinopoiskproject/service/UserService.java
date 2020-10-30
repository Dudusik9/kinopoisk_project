package org.example.kinopoiskproject.service;

import org.example.kinopoiskproject.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);
    boolean activateUser(String code);
}
