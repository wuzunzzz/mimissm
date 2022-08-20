package com.wzz.mapper;

import com.wzz.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> getAll();



    int delete(int oid);

    List<Order> selectByUid(String uid);


}
