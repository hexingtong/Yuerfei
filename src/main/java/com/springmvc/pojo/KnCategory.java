package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.Date;
@Repository
public class KnCategory {

    private Integer id;

    /**
     *
     类别名称
     */
    private String title;

    /**
     *
     类别图片
     */
    private String img;

    /**
     *
     排序级别（100最小）
     */
    private Integer level;

    /**
     *
     添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}