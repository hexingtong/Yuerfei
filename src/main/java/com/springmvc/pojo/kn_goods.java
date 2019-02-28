package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品类
 */
public class kn_goods implements Serializable {
    //id
    private int id;
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
    //申请攻略的文字说明
    private String Application_strategy;
    //申请攻略的图片说明
    private String Application_strategy_img;
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
    //上架状态（1保存2上架3下架）
    private int status;
    //添加时间
    private Date add_time;
    //激活流程
    private String activation;
    //首页图
    private String homepicture;
    //有无连接状态码
    private int statusCode;

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
                ", Application_strategy='" + Application_strategy + '\'' +
                ", Application_strategy_img='" + Application_strategy_img + '\'' +
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
                '}';
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

    public void setApplication_strategy(String application_strategy) {
        Application_strategy = application_strategy;
    }

    public void setApplication_strategy_img(String application_strategy_img) {
        Application_strategy_img = application_strategy_img;
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

    public String getApplication_strategy() {
        return Application_strategy;
    }

    public String getApplication_strategy_img() {
        return Application_strategy_img;
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
