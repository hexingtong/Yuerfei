package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品类别
 */
public class kn_category implements Serializable {
    private  int id;
    //类别名称
    private String title;
    //类别图片
    private String img;
    //排序级别（100最小）
    private String level;
    //添加时间
    private Date add_time;

    @Override
    public String toString() {
        return "kn_category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", level='" + level + '\'' +
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

    public void setLevel(String level) {
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

    public String getLevel() {
        return level;
    }

    public Date getAdd_time() {
        return add_time;
    }
}
