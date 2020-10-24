package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.UserDto;
import org.example.kinopoisk_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('write')")
    public UserDto getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('write')")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    public UserDto saveUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('write')")
    public UserDto updateUser(@RequestBody UserDto user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
