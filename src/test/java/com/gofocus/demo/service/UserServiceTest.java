package com.gofocus.demo.service;

import com.gofocus.demo.entity.User;
import com.gofocus.demo.dao.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.*;

/**
 * @Author: GoFocus
 * @Date: 2020-06-10 10:08
 * @Description:
 */

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserMapper userMapper;
    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @InjectMocks
    UserService userService;


    @Test
    void save() {
        when(bCryptPasswordEncoder.encode("password")).thenReturn("encodedPassword");
        userService.save("username", "password");
        verify(userMapper).save("username", "encodedPassword");
    }

    @Test
    void getUserByUsername() {
        userService.getUserByUsername("username");
        verify(userMapper).findUserByUsername("username");
    }

    @Test
    void loadUserByUsernameWhileUserIsNull() {
//        Mockito.when(userMapper.findUserByUsername("username")).thenReturn(null);
        Assertions.assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("username"));
    }

    @Test
    void loadUserByUsernameWhileUserIsNotNull() {
        when(userMapper.findUserByUsername("username")).thenReturn(new User(1, "username", "encodedPassword"));
        UserDetails userDetails = userService.loadUserByUsername("username");
        Assertions.assertEquals("username",userDetails.getUsername());
        Assertions.assertEquals("encodedPassword",userDetails.getPassword());
    }
}