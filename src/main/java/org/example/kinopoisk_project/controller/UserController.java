package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.UserDto;
import org.example.kinopoisk_project.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    public UserDto getUser(){
        return new UserDto();
    }

    @PostMapping
    public UserDto saveUset(@RequestBody UserDto user){
        return user;
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto user){
        return user;
    }

    @DeleteMapping
    public void deleteFeedback(){
        System.out.println("User was deleted");
    }
}
