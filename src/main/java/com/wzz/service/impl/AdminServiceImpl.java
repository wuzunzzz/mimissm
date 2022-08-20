package com.wzz.service.impl;

import com.wzz.mapper.AdminMapper;
import com.wzz.pojo.Admin;
import com.wzz.pojo.AdminExample;
import com.wzz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //在业务逻辑层中,一定会有数据访问层的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {

        //根据传入的用户或到DB中查询相应用户对象
        //如果有条件 ,则一定要创建AdminExample的对象,用来封装条件
        AdminExample example = new AdminExample();
        //添加用户名a_name条件
        example.createCriteria().andANameEqualTo(name);

        List<Admin> list = adminMapper.selectByExample(example);
        if(list.size() > 0 ){
            Admin admin = list.get(0);
            if(pwd.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }

    @Override
    public String addAdmin(String aName, String aPass) {
        String a = "yes";
        AdminExample example = new AdminExample();
        example.createCriteria().andANameEqualTo(aName);
        List<Admin> list = adminMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            a = "no";
        } else {
            Admin admin = new Admin();
            admin.setaName(aName);
            admin.setaPass(aPass);
            adminMapper.addAdmin(admin);
        }
        return a;
    }


}
