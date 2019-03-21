package com.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
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
    //增加时“
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "add_time")
    private Date addTime;
    //pv
    private int pv;
    //uv
    private int uv;
    //点击量
    private int click;
    //上架状态
    private int status;
    //注册人数
    private int enrollment;

    @Override
    public String toString() {
        return "kn_friend{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", logo='" + logo + '\'' +
                ", level=" + level +
                ", addTime=" + addTime +
                ", pv=" + pv +
                ", uv=" + uv +
                ", click=" + click +
                ", status=" + status +
                ", enrollment=" + enrollment +
                '}';
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public int getEnrollment() {

        return enrollment;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {

        return status;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getClick() {

        return click;
    }

    public int getPv() {
        return pv;
    }

    public int getUv() {
        return uv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setUv(int uv) {
        this.uv = uv;
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

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getAddTime() {

        return addTime;
    }
}
