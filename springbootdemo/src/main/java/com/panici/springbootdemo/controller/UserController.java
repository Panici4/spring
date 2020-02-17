package com.panici.springbootdemo.controller;

import com.panici.springbootdemo.dao.UserDAO;
import com.panici.springbootdemo.entity.User;
import com.panici.springbootdemo.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") String userId) {
        User user = this.userDAO.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

}
