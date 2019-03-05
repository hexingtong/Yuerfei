package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.Date;
/**
 * Description：友情链接表
 * @author boyang
 * @date 2019/3/5 19:25
 * @param
 * @return
 */
@Repository
public class KnFriend {

    private Short id;

    /**
     *
     站点名称
     */
    private String title;

    /**
     *
     网址链接
     */
    private String url;

    /**
     *
     站点logo
     */
    private String img;

    /**
     排序级别（100最小）
     */
    private Byte level;

    /**
     *
     添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     *
     注册人数
     */
    private Integer enrollment;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }
}