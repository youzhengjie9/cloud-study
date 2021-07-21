package com.boot.service;

import com.pojo.user;

/**
 * @author 游政杰
 */
public interface UserService {


    user selectUserMoney(String username);

    void insertUser(user user);
}
