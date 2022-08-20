package com.wzz.service;


import com.wzz.pojo.Order;
import com.wzz.pojo.vo.OrderVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    PageInfo splitPage(int pageNum, int pageSize);

    PageInfo splitPage2(int pageNum, int pageSize ,String name);

    int delete(int oid);

    PageInfo selectByUid(String uid);

    PageInfo<Order> splitPageVo(OrderVo vo, int pageSize);
}
