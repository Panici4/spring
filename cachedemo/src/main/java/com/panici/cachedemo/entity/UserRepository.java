package com.panici.cachedemo.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRepository {

    private ConcurrentHashMap<String, User> concurrentHashMap;

    @PostConstruct
    public void init() {
        this.concurrentHashMap = new ConcurrentHashMap<>(2);
        User user = new User();
        user.setId("1");
        user.setUsername("abcd");
        user.setPassword("abcd");
        concurrentHashMap.put(user.getId(), user);
    }


    public User getUserById(String id) {
        System.out.println("从存储层获取数据");
        return this.concurrentHashMap.get(id);
    }


    public void updateUser(User user) {
        System.out.println("更新存储层数据");
        this.concurrentHashMap.put(user.getId(), user);
    }

}
