package com.wzz.controller;

import com.wzz.pojo.User;
import com.wzz.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserAction {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String name , String pwd, HttpServletRequest request,HttpSession session){
        User user = userService.login(name,pwd);
        if(user != null){
            //request.setAttribute("name",name);
            session.setAttribute("name",name);
            //登录成功
            return "main2";
        }else{
            //登录失败
            request.setAttribute("errmsg","用户名或密码不正确!");
            return "login2";
        }
    }
    @RequestMapping("/regist")
    public  String regist(User user,HttpServletRequest request){
        String a = userService.add(user);
        if("no"==a){
            request.setAttribute("msg","该用户名重复！");
            return "regist2";
        }else {
            request.setAttribute("msg","注册成功！");
            return "login2";
        }
    }
    @ResponseBody
    @RequestMapping("/select")
    public void selectByName(String name,HttpSession session){
        PageInfo info = userService.select(name);
        session.setAttribute("info",info);
    }

    @RequestMapping("/split")
    public String split(HttpServletRequest request) {
        PageInfo info = userService.splitPage(1, 5);
        request.setAttribute("info", info);
        return "user";
    }

    @RequestMapping("/ajax")
    public String ajaxSplit(int page, HttpSession session) {
        //取得当前page参数的页面的数据
        PageInfo info = userService.splitPage(page, 5);
        session.setAttribute("info", info);
        return "user";
    }

    @RequestMapping("/delete")
    public String delete(int id, HttpServletRequest request) {
        int num = -1;

        try {
            num = userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (num > 0) {
            request.setAttribute("msg", "删除成功!");
        } else {
            request.setAttribute("msg", "删除失败!");
        }

        //删除结束后跳到分页显示
        return "forward:/user/deleteAjaxSplit.action";
    }
    @ResponseBody
    @RequestMapping(value = "/deleteAjaxSplit", produces = "text/html;charset=UTF-8")
    public Object deleteAjaxSplit(HttpServletRequest request) {
        //取得第1页的数据
        PageInfo info = userService.splitPage(1, 5);
        request.getSession().setAttribute("info",info);
        return request.getAttribute("msg");
    }
    
}
