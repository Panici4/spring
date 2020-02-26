package com.panici.cachedemo.service.impl;

import com.panici.cachedemo.entity.User;
import com.panici.cachedemo.entity.UserRepository;
import com.panici.cachedemo.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        Assert.notNull(userRepository, "UserRepository must not be null!");
        this.userRepository = userRepository;
    }

    @Override
    @Cacheable(cacheNames = "user", key = "#id")
    public User getUserById(String id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    @CacheEvict(cacheNames = "user", key = "#user.id")
    public void updateUser(User user) {
        //由于缓存是基于AOP实现的，此处不会使用缓存，直接从数据库查询。
        User userInDb = getUserById(user.getId());
        if (userInDb == null) {
            throw new RuntimeException(String.format("user %s not exist", user.getId()));
        }
        this.userRepository.updateUser(user);
    }
}
