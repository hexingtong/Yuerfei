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
    private String cgl;
    //额度
    private String ed;
    //期限
    private String qx;
    //利率
    private String fy;
    //放贷速度
    private String fdsd;
    //审核方式
    private String shfs;
    //到账方式
    private String dzfs;
    //征信要求
    private String zxyq;
    //平台名称
    private String ptmc;
    //申请攻略的文字说明
    private String sqgl;
    //申请攻略的图片说明
    private String sqgl_img;
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
                ", cgl='" + cgl + '\'' +
                ", ed='" + ed + '\'' +
                ", qx='" + qx + '\'' +
                ", fy='" + fy + '\'' +
                ", fdsd='" + fdsd + '\'' +
                ", shfs='" + shfs + '\'' +
                ", dzfs='" + dzfs + '\'' +
                ", zxyq='" + zxyq + '\'' +
                ", ptmc='" + ptmc + '\'' +
                ", sqgl='" + sqgl + '\'' +
                ", sqgl_img='" + sqgl_img + '\'' +
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

    public void setCgl(String cgl) {
        this.cgl = cgl;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public void setQx(String qx) {
        this.qx = qx;
    }

    public void setFy(String fy) {
        this.fy = fy;
    }

    public void setFdsd(String fdsd) {
        this.fdsd = fdsd;
    }

    public void setShfs(String shfs) {
        this.shfs = shfs;
    }

    public void setDzfs(String dzfs) {
        this.dzfs = dzfs;
    }

    public void setZxyq(String zxyq) {
        this.zxyq = zxyq;
    }

    public void setPtmc(String ptmc) {
        this.ptmc = ptmc;
    }

    public void setSqgl(String sqgl) {
        this.sqgl = sqgl;
    }

    public void setSqgl_img(String sqgl_img) {
        this.sqgl_img = sqgl_img;
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

    public String getCgl() {
        return cgl;
    }

    public String getEd() {
        return ed;
    }

    public String getQx() {
        return qx;
    }

    public String getFy() {
        return fy;
    }

    public String getFdsd() {
        return fdsd;
    }

    public String getShfs() {
        return shfs;
    }

    public String getDzfs() {
        return dzfs;
    }

    public String getZxyq() {
        return zxyq;
    }

    public String getPtmc() {
        return ptmc;
    }

    public String getSqgl() {
        return sqgl;
    }

    public String getSqgl_img() {
        return sqgl_img;
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
