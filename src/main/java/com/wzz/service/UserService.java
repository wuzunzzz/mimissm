package com.wzz.service;

import com.wzz.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    User login(String name,String pass);

    String add(User user);

    PageInfo select(String name);

    List<User> getAll();

    PageInfo splitPage(int pageNum, int pageSize);

    int delete(int id);

}
