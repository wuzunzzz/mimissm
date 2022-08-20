package com.wzz.service.impl;

import com.wzz.mapper.OrderMapper;
import com.wzz.pojo.Order;
import com.wzz.pojo.vo.OrderVo;
import com.wzz.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceIml implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<Order> getAll() {
        List<Order> all = orderMapper.getAll();
        return all;
    }

    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> all = orderMapper.getAll();
        PageInfo<Order> orderPageInfo = new PageInfo<>(all);
        return orderPageInfo;
    }

    public PageInfo splitPage2(int pageNum, int pageSize ,String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> all = orderMapper.selectByUid(name);
        PageInfo<Order> orderPageInfo = new PageInfo<>(all);
        return orderPageInfo;
    }

    @Override
    public int delete(int oid) {
        int i = orderMapper.delete(oid);
        return i;
    }

    @Override
    public PageInfo selectByUid(String uid) {
        PageHelper.startPage(1,5);
        List<Order> list = orderMapper.selectByUid(uid);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Order> splitPageVo(OrderVo vo, int pageSize) {
        return null;
    }
}
