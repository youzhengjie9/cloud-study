package com.boot.mapper;

import com.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 游政杰
 */
@Repository
@Mapper
public interface UserMapper {


    user selectUserMoney(@Param("username") String username);


    void insertUser(user user);

}
