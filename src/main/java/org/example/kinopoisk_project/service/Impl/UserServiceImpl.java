package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.UserDto;
import org.example.kinopoisk_project.entity.User;
import org.example.kinopoisk_project.repository.UserRepository;
import org.example.kinopoisk_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User didn't find"));
        return UserDto.builder().id(user.getId()).nickname(user.getNickname()).build();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = (List)userRepository.findAll();
        return userList.stream()
                .map(user -> UserDto.builder().id(user.getId()).nickname(user.getNickname()).build())
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto)
    {
        User user = new User();
        user.setNickname(userDto.getNickname());
        user = userRepository.save(user);
        return UserDto.builder().id(user.getId()).nickname(user.getNickname()).build();
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new IllegalArgumentException("User didn't find"));
        user.setNickname(userDto.getNickname());
        user = userRepository.save (user);
        return UserDto.builder().id(user.getId()).nickname(user.getNickname()).build();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
