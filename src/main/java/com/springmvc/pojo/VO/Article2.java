package com.springmvc.pojo.VO;

import com.springmvc.pojo.Article;

import javax.persistence.Column;

/**
 * @ClassName Article2
 * @Description:
 * @Author by
 * @Date: 2019/5/7 11:40
 **/
public class Article2 extends Article {
    /**
     * 用户头像
     */
    @Column(name = "img")
    private String img;
    /**
     * 用户名字
     */
    @Column(name = "title")
    private String title;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
