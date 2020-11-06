package org.example.kinopoiskproject.service.impl;

import org.example.kinopoiskproject.dto.UserDto;
import org.example.kinopoiskproject.entity.User;
import org.example.kinopoiskproject.repository.RoleRepository;
import org.example.kinopoiskproject.repository.UserRepository;
import org.example.kinopoiskproject.service.MailSender;
import org.example.kinopoiskproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ConversionService conversionService, RoleRepository roleRepository, MailSender mailSender, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
        this.roleRepository = roleRepository;
        this.mailSender = mailSender;
        this.passwordEncoder = passwordEncoder;
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
        user.setActivationCode(UUID.randomUUID().toString());

        sendEmail(user);

        user = userRepository.save(user);
        return conversionService.convert(user, UserDto.class);
    }

    public void sendEmail(User user){
        if(user.getEmail() != null) {
            String message = String.format(
                    "Hello, %s\n" +
                            "Welcome to custom kinopoisk project from Dudusik!\n\n" +
                            "For activate your account visit next link: http://localhost:8080/api/v1/user/activate/%s\n" +
                            "Please, don't replay on this letter",
                    user.getNickname(),
                    user.getActivationCode());
            mailSender.send(user.getEmail(), "Activation code", message);
        }
    }

    @Override
    public boolean activateUser(String code) {
//        User didn't find
        if(!userRepository.findByActivationCode(code).isPresent())
            return false;
//        If user exist
        User user = userRepository.findByActivationCode(code).get();
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
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserRole(roleRepository.findById(userDto.getIdRole()).orElseThrow(IllegalArgumentException::new));
        user = userRepository.save (user);
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
