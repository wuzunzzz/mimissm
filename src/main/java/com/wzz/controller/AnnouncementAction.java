package com.wzz.controller;

import com.wzz.pojo.Announcement;
import com.wzz.service.AnnouncementService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/announce")
public class AnnouncementAction {
    @Autowired
    private AnnouncementService announcementService;
    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request){
        List<Announcement> a = announcementService.getAll();
        request.setAttribute("a", a);
        return "announcement";
    }
    @RequestMapping("/split")
    public String split(HttpServletRequest request) {
        PageInfo info = announcementService.splitPage(1, 3);
        request.setAttribute("info", info);
        return "announcement";
    }
    @RequestMapping("/split2")
    public String split2(HttpServletRequest request) {
        PageInfo info = announcementService.splitPage(1, 3);
        request.setAttribute("info", info);
        return "announcement2";
    }

    @RequestMapping("/ajax")
    public String ajaxSplit(int page, HttpSession session) {
        //取得当前page参数的页面的数据
        PageInfo info = announcementService.splitPage(page,3);
        session.setAttribute("info", info);
        return "announcement";
    }
    @RequestMapping("/ajax2")
    public String ajaxSplit2(int page, HttpSession session) {
        //取得当前page参数的页面的数据
        PageInfo info = announcementService.splitPage(page,3);
        session.setAttribute("info", info);
        return "announcement2";
    }

    @RequestMapping("/delete")
    public String delete(int id, HttpServletRequest request) {
        int num = -1;
        try {
            num = announcementService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (num > 0) {
            request.setAttribute("msg", "删除成功!");
        } else {
            request.setAttribute("msg", "删除失败!");
        }

        //删除结束后跳到分页显示
        return "forward:/announce/deleteAjaxSplit.action";
    }
    @ResponseBody
    @RequestMapping(value = "/deleteAjaxSplit", produces = "text/html;charset=UTF-8")
    public Object deleteAjaxSplit(HttpServletRequest request) {
        //取得第1页的数据
        PageInfo info = announcementService.splitPage(1,3);
        request.getSession().setAttribute("info",info);
        return request.getAttribute("msg");
    }

    @RequestMapping("/add")
    public String add(Announcement announcement,HttpServletRequest request){
        int num = announcementService.add(announcement);
        if (num > 0) {
            request.setAttribute("msg", "增加成功!");
        } else {
            request.setAttribute("msg", "增加失败!");
        }
        return "forward:/announce/split.action";
    }

    @RequestMapping("/update")
    public String update(Announcement announcement, HttpServletRequest request){
        int num = announcementService.update(announcement);
        if (num > 0) {
            //此时说明更新成功
            request.setAttribute("msg", "更新成功!");
        } else {
            //更新失败
            request.setAttribute("msg", "更新失败!");
        }
        return "forward:/announce/split.action";
    }

    @RequestMapping("/one")
    public String one(int id, HttpSession session) {
        Announcement info = announcementService.getByID(id);
        session.setAttribute("prod", info);
        return "update1";
    }

    @RequestMapping("/deleteBatch")
    //pids="1,4,5"  ps[1,4,5]
    public String deleteBatch(String pids,HttpServletRequest request){
        //将上传上来的字符串截开,形成商品id的字符数组
        String []ps = pids.split(",");

        try {
            int num = announcementService.deleteBatch(ps);
            if(num > 0 ){
                request.setAttribute("msg","批量删除成功!");
            }else{
                request.setAttribute("msg","批量删除失败!");
            }
        } catch (Exception e) {
            request.setAttribute("msg","商品不可删除!");
        }
        return "forward:/announce/deleteAjaxSplit.action";
    }
}