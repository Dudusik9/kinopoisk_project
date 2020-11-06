package unit.org.example.kinopoiskproject.service.impl;

import org.example.kinopoiskproject.dto.UserDto;
import org.example.kinopoiskproject.entity.User;
import org.example.kinopoiskproject.entity.UserRole;
import org.example.kinopoiskproject.repository.RoleRepository;
import org.example.kinopoiskproject.repository.UserRepository;
import org.example.kinopoiskproject.service.MailSender;
import org.example.kinopoiskproject.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private  UserRepository userRepository;
    @Mock
    private  ConversionService conversionService;
    @Mock
    private  RoleRepository roleRepository;
    @Mock
    private  MailSender mailSender;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetUserByIdSuccessfully(){
        User user = new User();
        UserDto userDto = new UserDto();
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(conversionService.convert(user, UserDto.class)).thenReturn(userDto);
        UserDto result = userServiceImpl.getUserById(1L);
        Assert.assertSame(result, userDto);
    }

    @Test
    public void testGetUserByIdWhenReturnIllegalArgumentException(){
            Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());
            exception.expect(IllegalArgumentException.class);
            userServiceImpl.getUserById(1L);
    }

    @Test
    public void testGetAllUsersPass(){
        ArrayList<User> listUsers = new ArrayList<>();
        User user = new User();
        Mockito.when(userRepository.findAll()).thenReturn(listUsers);
        Mockito.verify(conversionService, Mockito.times(userServiceImpl.getAllUsers().size())).convert(user, UserDto.class);
        userServiceImpl.getAllUsers();
    }

    @Test
    public void testGetAllUsersWhenReturnNullPointerException(){
        Mockito.when(userRepository.findAll()).thenReturn(null);
        exception.expect(NullPointerException.class);
        userServiceImpl.getAllUsers();
    }

    @Test
    public void testCreateUserSuccessfully(){
        UserDto inputUserDto = new UserDto();
        User user = new User();
        user.setEmail("testEmail");

        Mockito.when(conversionService.convert(inputUserDto, User.class)).thenReturn(user);
        userServiceImpl.createUser(inputUserDto);

        Mockito.verify(conversionService, Mockito.times(2)).convert(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
        Mockito.verify(mailSender, Mockito.times(1))
                .send(ArgumentMatchers.eq(user.getEmail())
                        , ArgumentMatchers.anyString()
                        , ArgumentMatchers.anyString());
    }

    @Test
    public void testCreateUserWhenUserAlreadyExists(){
        UserDto inputUserDto = new UserDto();
        inputUserDto.setNickname("TestName");
        User user = new User();
        Mockito.when(userRepository.findByNickname("TestName")).thenReturn(Optional.of(user));
        exception.expect(IllegalArgumentException.class);
        userServiceImpl.createUser(inputUserDto);
    }

    @Test
    public void testCreateUserWhenEmailAlreadyExists(){
        UserDto inputUserDto = new UserDto();
        inputUserDto.setEmail("TestEmail");
        User user = new User();
        Mockito.when(userRepository.findByEmail("TestEmail")).thenReturn(Optional.of(user));
        exception.expect(IllegalArgumentException.class);
        userServiceImpl.createUser(inputUserDto);
    }

    @Test
    public void testCreateUserWithoutEmail(){
        UserDto inputUserDto = new UserDto();
        User user = new User();
        user.setEmail(null);

        Mockito.when(conversionService.convert(inputUserDto, User.class)).thenReturn(user);
        userServiceImpl.createUser(inputUserDto);

        Mockito.verify(mailSender, Mockito.times(0))
                .send(ArgumentMatchers.eq(null)
                        , ArgumentMatchers.anyString()
                        , ArgumentMatchers.anyString());
    }

    @Test
    public void testActivateUserSuccessfully(){
        String code = "testCode";
        User user = new User();
        Mockito.when(userRepository.findByActivationCode(code)).thenReturn(Optional.of(user));
        boolean result = userServiceImpl.activateUser(code);

        Assert.assertTrue(result);

        Mockito.verify(userRepository, Mockito.times(2)).findByActivationCode(ArgumentMatchers.anyString());
        Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.isA(User.class));
    }

    @Test
    public void testActivateWhenUserDidntFind(){
        String code = "testCode";
        Mockito.when(userRepository.findByActivationCode(code)).thenReturn(Optional.empty());
        boolean result = userServiceImpl.activateUser(code);

        Assert.assertFalse(result);
    }

    @Test
    public  void testUpdateUserSuccessfully(){
        UserDto userDto = new UserDto();
        User user = new User();
        UserRole role = new UserRole();
        Mockito.when(userRepository.findById(userDto.getId())).thenReturn(Optional.of(user));
        Mockito.when(passwordEncoder.encode(userDto.getPassword())).thenReturn("testPassword");
        Mockito.when(roleRepository.findById(userDto.getIdRole())).thenReturn(Optional.of(role));
        userServiceImpl.updateUser(userDto);

        Mockito.verify(userRepository, Mockito.times(1)).findById(ArgumentMatchers.any());
        Mockito.verify(passwordEncoder, Mockito.times(1)).encode(ArgumentMatchers.any());
        Mockito.verify(roleRepository, Mockito.times(1)).findById(ArgumentMatchers.any());
        Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.isA(User.class));
        Mockito.verify(conversionService, Mockito.times(1)).convert(ArgumentMatchers.any(), ArgumentMatchers.any());
    }

    @Test
    public  void testUpdateUserWhenDidntFindUser(){
        UserDto userDto = new UserDto();
        Mockito.when(userRepository.findById(userDto.getId())).thenReturn(Optional.empty());
        exception.expect(IllegalArgumentException.class);
        userServiceImpl.updateUser(userDto);
    }

    @Test
    public  void testUpdateUserWhenPasswordDoesntExist(){
        UserDto userDto = new UserDto();
//        Mockito.when(passwordEncoder.encode(userDto.getPassword())).thenReturn(null);
        exception.expect(IllegalArgumentException.class);
        userServiceImpl.updateUser(userDto);
    }

    @Test
    public  void testUpdateUserWhenRoleDoesntExist(){
        UserDto userDto = new UserDto();
//        Mockito.when(roleRepository.findById(userDto.getIdRole())).thenReturn(Optional.empty());
        exception.expect(IllegalArgumentException.class);
        userServiceImpl.updateUser(userDto);
    }

    @Test
    public  void testUpdateUserWhenSaveUserFailed(){
        UserDto userDto = new UserDto();
        User user = new User();
        UserRole role = new UserRole();
        Mockito.when(userRepository.findById(userDto.getId())).thenReturn(Optional.of(user));
        Mockito.when(roleRepository.findById(userDto.getIdRole())).thenReturn(Optional.of(role));
        Mockito.when(userRepository.save(user)).thenThrow(new PersistenceException());
        exception.expect(PersistenceException.class);
        userServiceImpl.updateUser(userDto);
    }

    @Test
    public void testDeleteUserSuccessfully(){
        Long userId = 1L;
        userServiceImpl.deleteUser(userId);
    }

    @Test
    public void testDeleteUserFailed(){
        Long userId = 1L;
        Mockito.doThrow(new IllegalArgumentException()).when(userRepository).deleteById(userId);
        exception.expect(IllegalArgumentException.class);
        userServiceImpl.deleteUser(userId);
    }
}
