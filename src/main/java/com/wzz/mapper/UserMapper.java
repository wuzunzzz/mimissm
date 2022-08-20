package com.wzz.mapper;

import com.wzz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User select(String name);

    int add(User user);

    List<User> getAll();

    List<User> select1(@Param("name") String name);

    int delete(int id);

}
