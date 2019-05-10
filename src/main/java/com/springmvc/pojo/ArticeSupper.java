package com.springmvc.pojo;

public class ArticeSupper extends Article {

    //判断状态
    private Integer index;
    //昵称
    private String name;
    //用户头像图片
    private String img;
    //用户手机号
    private String phone;

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getPhone() {
        return phone;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
