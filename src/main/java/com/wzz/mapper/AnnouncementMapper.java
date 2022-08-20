package com.wzz.mapper;

import com.wzz.pojo.Announcement;

import java.util.List;
public interface AnnouncementMapper {
    List<Announcement> getAll();

    int delete(int id);

    int add(Announcement announcement);

    int update(Announcement announcement);

    Announcement getById(int id);

    int deleteBatch(String []ids);

}
