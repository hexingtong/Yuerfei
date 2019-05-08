package com.springmvc.pojo.VO;

import com.springmvc.pojo.Article;

import javax.persistence.Column;
import java.util.List;

/**
 * @ClassName ArticleDetailVO
 * @Description: 评论详情页面展示VO
 * @Author by
 * @Date: 2019/5/6 11:26
 **/
public class ArticleDetailVO extends Article {

    /**
     * Description：图片集合
     * @return
     */
    private List imgList;

    /**
     * Description：评论集合
     * @return
     */
    private List commentList;
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

    public List getImgList() {
        return imgList;
    }

    public void setImgList(List imgList) {
        this.imgList = imgList;
    }

    public List getCommentList() {
        return commentList;
    }

    public void setCommentList(List commentList) {
        this.commentList = commentList;
    }
}
