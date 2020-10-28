package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.UserDto;
import org.example.kinopoisk_project.entity.User;
import org.example.kinopoisk_project.repository.RoleRepository;
import org.example.kinopoisk_project.repository.UserRepository;
import org.example.kinopoisk_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ConversionService conversionService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User didn't find"));
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = (List<User>)userRepository.findAll();
        return userList.stream()
                .map(user -> conversionService.convert(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto)
    {
        User user = conversionService.convert(userDto, User.class);
        user = userRepository.save(user);
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new IllegalArgumentException("User didn't find"));
        user.setNickname(userDto.getNickname());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setUserRole(roleRepository.findById(userDto.getIdRole()).orElseThrow(IllegalArgumentException::new));
        user = userRepository.save (user);
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
