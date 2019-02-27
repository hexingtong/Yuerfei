package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 */
@Repository
public class kn_admin  implements Serializable{
    //id
 private Integer id;
 //姓名
 private String title;
//电话
 private  String phone;
 //管理员权限
 private Integer level;
 //头像
    private  String img;
    //增加时间
    private Date add_time;
    //最近登录时间
    private  Date login_time;
    //最近一次登录ip
    private  String login_ip;

    @Override
    public String toString() {
        return "kn_admin{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", level=" + level +
                ", img='" + img + '\'' +
                ", add_time=" + add_time +
                ", login_time=" + login_time +
                ", login_ip='" + login_ip + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getLevel() {
        return level;
    }

    public String getImg() {
        return img;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public String getLogin_ip() {
        return login_ip;
    }
}