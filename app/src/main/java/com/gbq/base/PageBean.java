package com.gbq.base;

/**
 * 分页
 * Created by gbq on 2016-9-24.
 */
public class PageBean {
    private int pageNo;
    private int pageSize;

    public PageBean() {
        // TODO Auto-generated constructor stub
    }

    public PageBean(int pageNo, int pageSize) {
        // TODO Auto-generated constructor stub
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
