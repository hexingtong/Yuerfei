package com.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

import static javax.print.attribute.standard.MediaPrintableArea.MM;

/**
 * 用户类
 */
@Repository
public class kn_admin  implements Serializable{

    @Id
    @GeneratedValue(generator = "JDBC")
 private Integer id;
 //姓名
 private String title;
//电话
 private  String phone;
 //管理员权限

 //用户密码
 private String pwd;

 private Integer level;

 //头像
    private  String img;

    @Transient
    private String token;
    //增加时“
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "add_time")
    private Date addTime;
    //最近登录时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "login_time")
    private  Date loginTime;
    //最近一次登录ip
    private  String loginIp;
    //注册来源
    private String registeredSource;

    //生成的用户id(uuid)
    private Integer adminId;
    //商家的认证状态(0:审核中。1：认证成功 2：认证失败)
    private Integer authenticationStatus;
    //企业名称
    private String enterpriseName;
    //证件号码
    private String idNumber;
    //邮箱
    private String email;
    //营业执照
    private String businessLicense;
    //认证信息
    private Integer authenticationMessage;


    public String getPwd() {
        return pwd;
    }

    public String getRegisteredSource() {
        return registeredSource;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public Integer getAuthenticationStatus() {
        return authenticationStatus;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public Integer getAuthenticationMessage() {
        return authenticationMessage;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setRegisteredSource(String registeredSource) {
        this.registeredSource = registeredSource;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public void setAuthenticationStatus(Integer authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public void setAuthenticationMessage(Integer authenticationMessage) {
        this.authenticationMessage = authenticationMessage;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}