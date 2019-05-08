package com.springmvc.pojo.VO;

import com.springmvc.pojo.Comment;

import javax.persistence.Column;

/**
 * @ClassName CommentVO
 * @Description: 自定义业务评论表
 * @Author by
 * @Date: 2019/5/6 14:05
 **/
public class CommentVO extends Comment {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
