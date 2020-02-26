package com.panici.cachedemo.service;

import com.panici.cachedemo.entity.User;

/**
 * 用户服务类
 */
public interface UserService {

    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户实例
     */
    User getUserById(String id);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

}
