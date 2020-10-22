package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.UserDto;
import org.example.kinopoisk_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long id){

        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
