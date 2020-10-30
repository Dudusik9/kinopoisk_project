package org.example.kinopoiskproject.controller;

import org.example.kinopoiskproject.dto.UserDto;
import org.example.kinopoiskproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PreAuthorize("hasAuthority('WRITE')")
    public UserDto getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/activate/{code}")
    @PreAuthorize("hasAuthority('WRITE')")
    public String activate (@PathVariable("code") String code){
        boolean isActivated = userService.activateUser(code);
        if(isActivated)
            return "Activation was successful";
        else
            return "Activation error";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public UserDto createUser(@Valid @RequestBody UserDto user){
        return userService.createUser(user);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public UserDto updateUser(@Valid @RequestBody UserDto user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('WRITE')")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
