package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品类
 */
public class kn_goods implements Serializable {
    //id
    private Integer id;
    //产品名称
    private String title;
    //类别id\
    private int category_id;
    //属性id
    private String property_ids;
    //标签图片id
    private int tag_id;
    //产品图片
    private String img;
    //申请成功率
    private String Success_rate;
    //额度
    private String Limit;
    //期限
    private String Deadline;
    //利率
    private String Interest_rate;
    //放贷速度
    private String Pace_lending;
    //审核方式
    private String Review_way;
    //到账方式
    private String Account_way;
    //征信要求
    private String Credit_required;
    //平台名称
    private String Platform_name;
    //产品详情申请条件
    private String application_requirement;
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
    private Date add_time;
    //激活流程
    private String activation;
    //首页图
    private String homepicture;
    //有无连接状态码
    private int statusCode;
    //cpa
    private String cpa;
    //点击
    private String pv;
    //独立访客
    private String uv;
    //uv收益
    private String uv_earnings;
    //cpa收益
    private String cpa_price;
    //关联用户表，只能是商家id
    private Integer admin_id;
    //点击量
    private Integer click;
    //详情表id
    private Integer details_id;
    //审核失败原因
    private String audit_failed;

    @Override
    public String toString() {
        return "kn_goods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category_id=" + category_id +
                ", property_ids='" + property_ids + '\'' +
                ", tag_id=" + tag_id +
                ", img='" + img + '\'' +
                ", Success_rate='" + Success_rate + '\'' +
                ", Limit='" + Limit + '\'' +
                ", Deadline='" + Deadline + '\'' +
                ", Interest_rate='" + Interest_rate + '\'' +
                ", Pace_lending='" + Pace_lending + '\'' +
                ", Review_way='" + Review_way + '\'' +
                ", Account_way='" + Account_way + '\'' +
                ", Credit_required='" + Credit_required + '\'' +
                ", Platform_name='" + Platform_name + '\'' +
                ", application_requirement='" + application_requirement + '\'' +
                ", details='" + details + '\'' +
                ", level=" + level +
                ", info='" + info + '\'' +
                ", url='" + url + '\'' +
                ", loogLine='" + loogLine + '\'' +
                ", appoint=" + appoint +
                ", status=" + status +
                ", add_time=" + add_time +
                ", activation='" + activation + '\'' +
                ", homepicture='" + homepicture + '\'' +
                ", statusCode=" + statusCode +
                ", cpa='" + cpa + '\'' +
                ", pv='" + pv + '\'' +
                ", uv='" + uv + '\'' +
                ", uv_earnings='" + uv_earnings + '\'' +
                ", cpa_price='" + cpa_price + '\'' +
                ", admin_id=" + admin_id +
                ", click=" + click +
                ", details_id=" + details_id +
                ", audit_failed='" + audit_failed + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setApplication_requirement(String application_requirement) {
        this.application_requirement = application_requirement;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCpa(String cpa) {
        this.cpa = cpa;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public void setUv_earnings(String uv_earnings) {
        this.uv_earnings = uv_earnings;
    }

    public void setCpa_price(String cpa_price) {
        this.cpa_price = cpa_price;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public void setDetails_id(Integer details_id) {
        this.details_id = details_id;
    }

    public void setAudit_failed(String audit_failed) {
        this.audit_failed = audit_failed;
    }

    public String getApplication_requirement() {

        return application_requirement;
    }

    public String getDetails() {
        return details;
    }

    public String getCpa() {
        return cpa;
    }

    public String getPv() {
        return pv;
    }

    public String getUv() {
        return uv;
    }

    public String getUv_earnings() {
        return uv_earnings;
    }

    public String getCpa_price() {
        return cpa_price;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public Integer getClick() {
        return click;
    }

    public Integer getDetails_id() {
        return details_id;
    }

    public String getAudit_failed() {
        return audit_failed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setProperty_ids(String property_ids) {
        this.property_ids = property_ids;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setSuccess_rate(String success_rate) {
        Success_rate = success_rate;
    }

    public void setLimit(String limit) {
        Limit = limit;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public void setInterest_rate(String interest_rate) {
        Interest_rate = interest_rate;
    }

    public void setPace_lending(String pace_lending) {
        Pace_lending = pace_lending;
    }

    public void setReview_way(String review_way) {
        Review_way = review_way;
    }

    public void setAccount_way(String account_way) {
        Account_way = account_way;
    }

    public void setCredit_required(String credit_required) {
        Credit_required = credit_required;
    }

    public void setPlatform_name(String platform_name) {
        Platform_name = platform_name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLoogLine(String loogLine) {
        this.loogLine = loogLine;
    }

    public void setAppoint(int appoint) {
        this.appoint = appoint;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public void setHomepicture(String homepicture) {
        this.homepicture = homepicture;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getProperty_ids() {
        return property_ids;
    }

    public int getTag_id() {
        return tag_id;
    }

    public String getImg() {
        return img;
    }

    public String getSuccess_rate() {
        return Success_rate;
    }

    public String getLimit() {
        return Limit;
    }

    public String getDeadline() {
        return Deadline;
    }

    public String getInterest_rate() {
        return Interest_rate;
    }

    public String getPace_lending() {
        return Pace_lending;
    }

    public String getReview_way() {
        return Review_way;
    }

    public String getAccount_way() {
        return Account_way;
    }

    public String getCredit_required() {
        return Credit_required;
    }

    public String getPlatform_name() {
        return Platform_name;
    }

    public int getLevel() {
        return level;
    }

    public String getInfo() {
        return info;
    }

    public String getUrl() {
        return url;
    }

    public String getLoogLine() {
        return loogLine;
    }

    public int getAppoint() {
        return appoint;
    }

    public int getStatus() {
        return status;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public String getActivation() {
        return activation;
    }

    public String getHomepicture() {
        return homepicture;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
