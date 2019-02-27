package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 站点信息表
 */
public class kn_website implements Serializable {
    //id
    private  int id;
    //站点名称
    private String title;
    //联系人
    private String manager;
    //联系手机
    private String mobile;
    //联系电话
    private String telephone;
    //邮箱
    private String email;
    //版权信息
    private String copyright;
    //微信公众号图片
    private String img;
    //简介
    private  String info;
    //地址
    private  String address;
    //更新时间
    private Date update_time;

    @Override
    public String toString() {
        return "kn_website{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", manager='" + manager + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", copyright='" + copyright + '\'' +
                ", img='" + img + '\'' +
                ", info='" + info + '\'' +
                ", address='" + address + '\'' +
                ", update_time=" + update_time +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getManager() {
        return manager;
    }

    public String getMobile() {
        return mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getImg() {
        return img;
    }

    public String getInfo() {
        return info;
    }

    public String getAddress() {
        return address;
    }

    public Date getUpdate_time() {
        return update_time;
    }
}
