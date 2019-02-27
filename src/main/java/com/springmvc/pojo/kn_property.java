package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品属性类
 */
public class kn_property  implements Serializable{
    //id
    private  int id;
    //属性名称
    private  String title;
    //图片

    private  String img;
    //排序级别（1最高级别）
    private  int level;
    //添加时间
    private Date add_time;

    @Override
    public String toString() {
        return "kn_property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
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

    public void setImg(String img) {
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public int getLevel() {
        return level;
    }

    public Date getAdd_time() {
        return add_time;
    }
}
