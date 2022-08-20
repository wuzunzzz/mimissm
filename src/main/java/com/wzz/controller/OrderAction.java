package com.wzz.controller;

import com.wzz.pojo.Order;
import com.wzz.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/order")
public class OrderAction {
    @Autowired
    OrderService orderService;
    @RequestMapping("/get")
    public String getAll(HttpServletRequest request) {
        List<Order> all = orderService.getAll();
        request.setAttribute("all", all);
        return "order";
    }
    @RequestMapping("/split")
    public String split(HttpServletRequest request) {
        PageInfo info = orderService.splitPage(1, 5);
        request.setAttribute("info", info);
        return "order";
    }
    @RequestMapping("/split2")
    public String split2(HttpSession session,HttpServletRequest request) {
        String name = (String)session.getAttribute("name");
        PageInfo info = orderService.splitPage2(1, 5,name);
        request.setAttribute("info", info);
        return "order2";
    }
    @RequestMapping("/ajax")
    public String ajaxSplit(int page, HttpSession session) {
        //取得当前page参数的页面的数据
        PageInfo info = orderService.splitPage(page, 5);
        session.setAttribute("info", info);
        return "order";
    }
    @RequestMapping("/ajax2")
    public String ajaxSplit2(int page, HttpSession session) {
        //取得当前page参数的页面的数据
        PageInfo info = orderService.splitPage(page, 5);
        session.setAttribute("info", info);
        return "order2";
    }
    @RequestMapping("/delete")
    public String delete(int oid, HttpServletRequest request) {
        int num = -1;

        try {
            num = orderService.delete(oid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (num > 0) {
            request.setAttribute("msg", "删除成功!");
        } else {
            request.setAttribute("msg", "删除失败!");
        }

        //删除结束后跳到分页显示
        return "forward:/order/deleteAjaxSplit.action";
    }
    @ResponseBody
    @RequestMapping(value = "/deleteAjaxSplit", produces = "text/html;charset=UTF-8")
    public Object deleteAjaxSplit(HttpServletRequest request) {
        //取得第1页的数据
        PageInfo info = orderService.splitPage(1, 5);
        request.getSession().setAttribute("info",info);
        return request.getAttribute("msg");
    }
    @ResponseBody
    @RequestMapping("/select")
    public void selectByUid(String uid,HttpSession session){
        PageInfo info = orderService.selectByUid(uid);
        session.setAttribute("info",info);
    }
}
