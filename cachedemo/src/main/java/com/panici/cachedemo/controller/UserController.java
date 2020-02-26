package com.panici.cachedemo.controller;

import com.panici.cachedemo.entity.User;
import com.panici.cachedemo.service.UserService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        Assert.notNull(userService, "UserService must not be null!");
        this.userService = userService;
    }

    @RequestMapping("/{id}")
    public User getUserInfo(@PathVariable("id") String id) {
        return this.userService.getUserById(id);
    }


    @PostMapping
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }
}
