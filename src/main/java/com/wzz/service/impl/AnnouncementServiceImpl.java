package com.wzz.service.impl;

import com.wzz.mapper.AnnouncementMapper;
import com.wzz.pojo.Announcement;
import com.wzz.service.AnnouncementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;
    @Override
    public List<Announcement> getAll() {
        List<Announcement> all = announcementMapper.getAll();
        return all;
    }

    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Announcement> all = announcementMapper.getAll();
        PageInfo<Announcement> announcementPageInfo = new PageInfo<>(all);
        return announcementPageInfo;
    }

    @Override
    public int delete(int id) {
        int i = announcementMapper.delete(id);
        return i;
    }

    @Override
    public int add(Announcement announcement) {
        int add = announcementMapper.add(announcement);
        return add;
    }

    @Override
    public Announcement getByID(int id) {
        Announcement a = announcementMapper.getById(id);
        return a;
    }

    @Override
    public int update(Announcement announcement) {
        return announcementMapper.update(announcement);
    }

    @Override
    public int deleteBatch(String[] ids) {
        return  announcementMapper.deleteBatch(ids);
    }
}
