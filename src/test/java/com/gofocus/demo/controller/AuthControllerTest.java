package com.gofocus.demo.controller;

import com.gofocus.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @Author: GoFocus
 * @Date: 2020-06-10 10:49
 * @Description:
 */

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class AuthControllerTest {
    private MockMvc mockMvc;

    @Mock
    AuthenticationManager authenticationManager;
    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AuthController(authenticationManager, userService)).build();
    }


    @Test
    void authNotLogin() throws Exception {
        mockMvc.perform(get("/auth")).andExpect(status().isOk())
                .andExpect(result -> Assertions.assertTrue(result.getResponse().getContentAsString().contains("用户未登录")));
    }

    @Test
    void authIsLogin() throws Exception {
//        mockMvc.perform(get("/auth")).andExpect()

    }

    @Test
    void register() {
    }

    @Test
    void logout() {
    }
}