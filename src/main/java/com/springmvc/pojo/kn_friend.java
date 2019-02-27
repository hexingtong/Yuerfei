package com.springmvc.pojo;

import java.util.Date;

/*
友情链接表
 */
public class kn_friend {
    //id
    private  int id;
    //站点名称
    private  String title;
    //网址链接
    private  String url;
    //站点logo
    private  String logo;
    //排序级别（100最小）
    private  int level;
    //添加时间
    private Date add_time;

    @Override
    public String toString() {
        return "kn_friend{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", logo='" + logo + '\'' +
                ", level=" + level +
                ", add_time=" + add_time +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getLogo() {
        return logo;
    }

    public int getLevel() {
        return level;
    }

    public Date getAdd_time() {
        return add_time;
    }
}
