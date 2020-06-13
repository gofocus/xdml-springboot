package com.gofocus.demo.service;

import com.gofocus.demo.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

/**
 * @Author: GoFocus
 * @Date: 2020-06-12 22:37
 * @Description:
 */


@Service
public class AuthService {

    private final UserService userService;

    @Inject
    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(userService.getUserByUsername(authentication == null ? null : authentication.getName()));
    }

}
