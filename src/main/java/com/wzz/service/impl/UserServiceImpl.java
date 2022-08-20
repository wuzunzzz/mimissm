package com.wzz.service.impl;

import com.wzz.mapper.UserMapper;
import com.wzz.pojo.User;
import com.wzz.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String name ,String pass) {
        User user = userMapper.select(name);
        if(user!=null){
            if(pass.equals(user.getA_pass())){
                return user;
            }
        }
        return null;
    }

    @Override
    public String add(User user) {
        String a = "yes";
        User user1 = userMapper.select(user.getA_name());
        if(user1!=null){
            a="no";
        }else {
            userMapper.add(user);
        }
        return a;
    }

    @Override
    public PageInfo select(String name) {
        PageHelper.startPage(1,5);
        List<User> list = userMapper.select1(name);
        return new PageInfo<>(list);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> all = userMapper.getAll();
        PageInfo<User> userPageInfo = new PageInfo<>(all);
        return userPageInfo;
    }

    @Override
    public int delete(int id) {
        return userMapper.delete(id);
    }

}
