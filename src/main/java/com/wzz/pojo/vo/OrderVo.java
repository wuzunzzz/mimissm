package com.wzz.pojo.vo;

public class OrderVo {
    private  int page;
    
    private  int uid;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public OrderVo(int page, int uid) {
        this.page = page;
        this.uid = uid;
    }
}
