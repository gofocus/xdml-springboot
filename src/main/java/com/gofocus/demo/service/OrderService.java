package com.gofocus.demo.service;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @Author: GoFocus
 * @Date: 2020-06-07 9:44
 * @Description:
 */

@Service
public class OrderService {

    private UserService userService;

    @Inject
    public OrderService(UserService userService) {
        this.userService = userService;
    }

    public void placeOrder(Integer userId, String item) {
        userService.getUserById(userId);
    }

}
