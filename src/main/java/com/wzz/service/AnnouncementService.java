package com.wzz.service;

import com.wzz.pojo.Announcement;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> getAll();

    PageInfo splitPage(int pageNum, int pageSize);

    int delete(int id);

    int add(Announcement announcement);

    Announcement getByID(int id);

    int update(Announcement announcement);

    int deleteBatch(String []ids);
}
