package com.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

import static javax.print.attribute.standard.MediaPrintableArea.MM;

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

 //用户密码
 private String pwd;

 private Integer level;

 //头像
    private  String img;

    @Transient
    private String token;
    //增加时“
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    @Column(name = "add_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date add_time;
    //最近登录时间
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm", timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "login_time")
    private  Date login_time;
    //最近一次登录ip
    private  String login_ip;
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

    @Override
    public String toString() {
        return "kn_admin{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", level=" + level +
                ", img='" + img + '\'' +
                ", token='" + token + '\'' +
                ", add_time=" + add_time +
                ", login_time=" + login_time +
                ", login_ip='" + login_ip + '\'' +
                ", registeredSource='" + registeredSource + '\'' +
                ", adminId=" + adminId +
                ", authenticationStatus=" + authenticationStatus +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", email='" + email + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", authenticationMessage=" + authenticationMessage +
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

    public void setToken(String token){this.token=token;}

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

    public String getToken(){return token;}
}