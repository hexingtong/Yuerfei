package com.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 产品类
 */
@Repository
public class kn_goods {
    //id
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    //产品名称
    private String title;
    //类别id\
    @Column(name = "category_id")
    private int categoryId;
    //属性id
    @Column(name = "property_ids")
    private String propertyIds;
    //标签图片id
    @Column(name = "tag_id")
    private int tagId;
    //产品图片
    private String img;
    //申请成功率
    @Column(name = "Success_rate")
    private String SuccessRate;
    //额度
    private String Limit;
    //期限
    private String Deadline;
    //利率
    @Column(name = "Interest_rate")
    private String Interestrate;
    //期限区域
    @Column(name = "Pace_lending")
    private String PaceLending;
    //审核方式
    @Column(name = "Review_way")
    private String ReviewWay;
    //征信要求
    @Column(name = "Credit_required")
    private String Creditrequired;
    //平台名称AccountWay
    @Column(name = "Account_way")
    private String AccountWay;
    //平台名称
    @Column(name = "Platform_name")
    private String Platformname;
    //产品详情申请条件
    @Column(name = "application_requirement")
    private String applicationrequirement;
    //产品详情描述
    private String details;
    //排序级别
    private int level;
    //简介
    private String info;
    //网址链接
    private String url;
    //循环额度
    private String loogLine;
    //推荐（1未推荐2推荐）
    private int appoint;
    //上架状态（上架状态(0审核中，1审核失败，2审核同过,3已上架，4保存））
    private int status;
    //添加时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "add_time")
    private Date addTime;
    //激活流程
    private String activation;
    //首页图
    private String homepicture;
    //有无连接状态码
    private int statusCode;
    //cpa
    private String cpa;
    //点击
    private Integer pv;
    //独立访客
    private Integer uv;
    //uv收益
    @Column(name = "uv_earnings")
    private String uvEarnings;
    //cpa收益
    @Column(name = "cpa_price")
    private String cpaPrice;
    //关联用户表，只能是商家id
    @Column(name = "admin_id")
    private Integer adminId;
    //点击量
    private Integer click;
    //详情表id
    @Column(name = "details_id")
    private Integer detailsId;
    //审核失败原因f
    @Column(name = "audit_failed")
    private String auditfailed;
    //已申请人数
    @Column(name = "apply_count")
    private Integer applyCount;

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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSuccessRate() {
        return SuccessRate;
    }

    public void setSuccessRate(String successRate) {
        SuccessRate = successRate;
    }

    public String getLimit() {
        return Limit;
    }

    public void setLimit(String limit) {
        Limit = limit;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public String getInterestrate() {
        return Interestrate;
    }

    public void setInterestrate(String interestrate) {
        Interestrate = interestrate;
    }

    public String getPaceLending() {
        return PaceLending;
    }

    public void setPaceLending(String paceLending) {
        PaceLending = paceLending;
    }

    public String getReviewWay() {
        return ReviewWay;
    }

    public void setReviewWay(String reviewWay) {
        ReviewWay = reviewWay;
    }

    public String getAccountWay() {
        return AccountWay;
    }

    public void setAccountWay(String accountWay) {
        AccountWay = accountWay;
    }

    public String getCreditrequired() {
        return Creditrequired;
    }

    public void setCreditrequired(String creditrequired) {
        Creditrequired = creditrequired;
    }

    public String getPlatformname() {
        return Platformname;
    }

    public void setPlatformname(String platformname) {
        Platformname = platformname;
    }

    public String getApplicationrequirement() {
        return applicationrequirement;
    }

    public void setApplicationrequirement(String applicationrequirement) {
        this.applicationrequirement = applicationrequirement;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLoogLine() {
        return loogLine;
    }

    public void setLoogLine(String loogLine) {
        this.loogLine = loogLine;
    }

    public int getAppoint() {
        return appoint;
    }

    public void setAppoint(int appoint) {
        this.appoint = appoint;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public String getHomepicture() {
        return homepicture;
    }

    public void setHomepicture(String homepicture) {
        this.homepicture = homepicture;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getCpa() {
        return cpa;
    }

    public void setCpa(String cpa) {
        this.cpa = cpa;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public String getUvEarnings() {
        return uvEarnings;
    }

    public void setUvEarnings(String uvEarnings) {
        this.uvEarnings = uvEarnings;
    }

    public String getCpaPrice() {
        return cpaPrice;
    }

    public void setCpaPrice(String cpaPrice) {
        this.cpaPrice = cpaPrice;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public String getAuditfailed() {
        return auditfailed;
    }

    public void setAuditfailed(String auditfailed) {
        this.auditfailed = auditfailed;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    @Override
    public String toString() {
        return "KnGoods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", propertyIds='" + propertyIds + '\'' +
                ", tagId=" + tagId +
                ", img='" + img + '\'' +
                ", SuccessRate='" + SuccessRate + '\'' +
                ", Limit='" + Limit + '\'' +
                ", Deadline='" + Deadline + '\'' +
                ", Interestrate='" + Interestrate + '\'' +
                ", PaceLending='" + PaceLending + '\'' +
                ", ReviewWay='" + ReviewWay + '\'' +
                ", AccountWay='" + AccountWay + '\'' +
                ", Creditrequired='" + Creditrequired + '\'' +
                ", Platformname='" + Platformname + '\'' +
                ", applicationrequirement='" + applicationrequirement + '\'' +
                ", details='" + details + '\'' +
                ", level=" + level +
                ", info='" + info + '\'' +
                ", url='" + url + '\'' +
                ", loogLine='" + loogLine + '\'' +
                ", appoint=" + appoint +
                ", status=" + status +
                ", addTime=" + addTime +
                ", activation='" + activation + '\'' +
                ", homepicture='" + homepicture + '\'' +
                ", statusCode=" + statusCode +
                ", cpa='" + cpa + '\'' +
                ", pv='" + pv + '\'' +
                ", uv='" + uv + '\'' +
                ", uvEarnings='" + uvEarnings + '\'' +
                ", cpaPrice='" + cpaPrice + '\'' +
                ", adminId=" + adminId +
                ", click=" + click +
                ", detailsId=" + detailsId +
                ", auditfailed='" + auditfailed + '\'' +
                ", applyCount=" + applyCount +
                '}';
    }

    public String getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(String propertyIds) {
        this.propertyIds = propertyIds;
    }
}
