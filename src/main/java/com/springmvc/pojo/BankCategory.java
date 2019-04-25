package com.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Repository
public class BankCategory {
    /**
     *自增id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     *银行名称
     */
    private String name;

    /**
     *银行图片
     */
    private String img;

    /**
     *添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "addTime")
    private Date addtime;

    /**
     *银行福利
     */
    private String welfare;


    /**
     * 发卡速度
     */
    private String speed;

    /**
     * 额度
     */
    private Double banklimit;

    /**
     * 通过率
     */
    private String passrate;
    /**
     第三方连接
     */
private  String shorturl;

    public String getShorturl() {
        return shorturl;
    }

    public void setShorturl(String shorturl) {
        this.shorturl = shorturl;
    }

    @Override
    public String toString() {
        return "BankCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", addtime=" + addtime +
                ", welfare='" + welfare + '\'' +
                ", speed='" + speed + '\'' +
                ", banklimit=" + banklimit +
                ", passrate='" + passrate + '\'' +
                ", shorturl='" + shorturl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Double getBanklimit() {
        return banklimit;
    }

    public void setBanklimit(Double banklimit) {
        this.banklimit = banklimit;
    }

    public String getPassrate() {
        return passrate;
    }

    public void setPassrate(String passrate) {
        this.passrate = passrate;
    }
}