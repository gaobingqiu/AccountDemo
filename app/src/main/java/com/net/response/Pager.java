package com.net.response;

import com.gbq.dto.News;

import java.util.List;

/**
 * 新闻列表返回
 * Created by gbq on 2016-9-24.
 */
public class Pager {
    private int code; // current page
    private String msg;
    private List<News> newslist;

    public List<News> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<News> newslist) {
        this.newslist = newslist;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
