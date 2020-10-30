package org.example.kinopoiskproject.service.Impl;

import org.example.kinopoiskproject.dto.UserDto;
import org.example.kinopoiskproject.entity.User;
import org.example.kinopoiskproject.repository.RoleRepository;
import org.example.kinopoiskproject.repository.UserRepository;
import org.example.kinopoiskproject.service.MailSender;
import org.example.kinopoiskproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;
    private final RoleRepository roleRepository;
    private final MailSender mailSender;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ConversionService conversionService, RoleRepository roleRepository, MailSender mailSender) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
        this.roleRepository = roleRepository;
        this.mailSender = mailSender;
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
//      Check User's nickname in database
        if (userRepository.findByNickname(userDto.getNickname()).isPresent()) {
            throw new IllegalArgumentException("User with this nickname is already exist! Please change you nickname");
        }
//        Check User's email in database
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User with this email is already exist! Please change you email");
        }

        User user = conversionService.convert(userDto, User.class);

//      Send email
        user.setActivationCode(UUID.randomUUID().toString());
        String message = String.format(
                "Hello, %s\n" +
                        "Welcome to custom kinopoisk project!\n'n" +
                "For activate your account visit next link: http://localhost:8080/api/v1/user/activate/%s",
                            user.getNickname(),
                            user.getActivationCode());
        mailSender.send(user.getEmail(), "Activation code", message);

        user = userRepository.save(user);
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public boolean activateUser(String code) {
//        User didn't find
        User user = userRepository.findByActivationCode(code).get();
        if(!userRepository.findByActivationCode(code).isPresent())
            return false;
//        User find
        user.setActivationCode("activated");
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new IllegalArgumentException("User didn't find in database"));
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
