package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
/**
 * Description：产品属性表
 * @author boyang
 * @date 2019/3/5 19:30
 * @param
 * @return
 */
@Repository
public class KnProperty {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     属性名称
     */
    private String title;

    /**
     图片
     */
    private String img;

    /**
     排序级别（1最高级别）
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