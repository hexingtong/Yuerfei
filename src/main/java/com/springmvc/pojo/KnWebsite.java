package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.Date;
/**  
 * Description：站点信息表
 * @author boyang
 * @date 2019/3/5 19:37
 * @param 
 * @return 
 */
@Repository
public class KnWebsite {

    private Integer id;
    /**
     *
     站点名称
     */
    private String title;

    /**
     *
     联系人
     */
    private String manager;

    /**
     联系手机
     */
    private String mobile;

    /**
     联系电话
     */
    private String telephone;

    /**
     *
     邮箱
     */
    private String email;

    /**
     *
     版权信息
     */
    private String copyright;

    /**
     *
     版权信息微信公众号图片
     */
    private String img;

    /**
     *
     简介
     */
    private String info;

    /**
     *
     地址
     */
    private String address;

    /**
     更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}