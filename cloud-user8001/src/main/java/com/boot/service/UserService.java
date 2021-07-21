package com.boot.service;

import com.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 游政杰
 */
public interface UserService {


    user selectUserMoney(String username);

    void insertUser(user user);
}
