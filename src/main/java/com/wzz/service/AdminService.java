package com.wzz.service;

import com.wzz.pojo.Admin;

public interface AdminService {
    //完成登录判断
    Admin login(String name, String pwd);

    String addAdmin(String aName,String aPass);
 
}
