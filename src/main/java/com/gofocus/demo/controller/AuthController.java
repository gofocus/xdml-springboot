package com.gofocus.demo.controller;

import com.gofocus.demo.entity.LoginResult;
import com.gofocus.demo.entity.User;
import com.gofocus.demo.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Map;

/**
 * @Author: GoFocus
 * @Date: 2020-06-08 15:05
 * @Description:
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserService userService;

    @Inject
    public AuthController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @GetMapping("")
    public Object auth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            return LoginResult.failure("用户未登录");
        }
        return LoginResult.success("已登录", userService.getUserByUsername(auth.getName()));
    }

    @PostMapping("/login")
    public LoginResult login(@RequestBody Map<String, Object> usernameAndPassword) {
        String username = usernameAndPassword.get("username").toString();
        String password = usernameAndPassword.get("password").toString();

        UserDetails userDetails = null;
        try {
            userDetails = userService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            return LoginResult.failure("用户不存在");
        }


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());

        try {
            authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(token);
            User loggedInUser = userService.getUserByUsername(username);
            return LoginResult.success("登录成功", loggedInUser);

        } catch (BadCredentialsException e) {
            return LoginResult.failure("密码不正确");
        }

    }

    @PostMapping("/register")
    public LoginResult register(@RequestBody Map<String, String> usernameAndPassword) {
        String username = usernameAndPassword.get("username");
        String password = usernameAndPassword.get("password");

        User user = userService.getUserByUsername(username);
        if (user != null) {
            return LoginResult.failure("用户名已存在");
        }
        userService.save(username, password);
        return LoginResult.success("注册成功", userService.getUserByUsername(username));

    }

    @GetMapping("/logout")
    public LoginResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return LoginResult.failure("用户尚未登录");
        }
        SecurityContextHolder.clearContext();
        return LoginResult.success("注销成功", null);
    }

}
