package com.wzz.controller;

import com.wzz.pojo.Admin;
import com.wzz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    //切记:在所有的界面层,一定会有业务逻辑层的对象
    @Autowired
    AdminService adminService;

    //实现登判断,并进行相应的跳转
    @RequestMapping("/login")
    public String login(String name , String pwd, HttpServletRequest request, HttpSession session){

        Admin admin = adminService.login(name,pwd);
        if(admin != null){
//            request.getServletContext().setAttribute("name",name);
            session.setAttribute("name",name);
            //登录成功
            return "main";
        }else{
            //登录失败
            request.setAttribute("errmsg","用户名或密码不正确!");
            return "/user/login2.jsp";
        }

    }
    @RequestMapping("/add")
    public  String addAdmin(String aName, String aPass, HttpServletRequest request){
        String a = adminService.addAdmin(aName,aPass);
        if ("no".equals(a)) {
            request.setAttribute("msg","该用户名重复！");
            return "regist";
        } else {
            request.setAttribute("msg","注册成功！");
            return "login3";
        }
    }


}
