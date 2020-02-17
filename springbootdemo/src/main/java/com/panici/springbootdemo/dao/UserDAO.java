package com.panici.springbootdemo.dao;

import com.panici.springbootdemo.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserDAO {

    private Map<String, User> userMap = new HashMap<>();

    @PostConstruct
    public void init() {
        User user = new User("123456","小明","xm123456");
        this.insertUser(user);
    }

    public User getUserById(String id) {
        return userMap.get(id);
    }


    public void insertUser(User user){
        this.userMap.put(user.getUserId(),user);
    }

}
