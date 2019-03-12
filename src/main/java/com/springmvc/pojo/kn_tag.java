package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签表
 */
public class kn_tag  implements Serializable{
    //id
    private  int id;
    //名称
    private  String title;
    //图片
    private  String img;
    //添加时间
    private Date add_time;

    @Override
    public String toString() {
        return "kn_tag{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
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

    public Date getAdd_time() {
        return add_time;
    }
}
