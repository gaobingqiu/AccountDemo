package com.gbq.dto;

/**
 * 新闻
 * Created by gbq on 2016-9-24.
 */
public class News {
    //时间
    private String ctime;
    //新闻标题
    private String title;
    //新闻摘要
    private String description;
    //新闻图片地址
    private String picUrl;
    //新闻web地址
    private String url;

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "News [ctime=" + ctime + ", title=" + title + ", description=" + description + ", picUrl=" + picUrl
                + ", url=" + url + "]";
    }
}
