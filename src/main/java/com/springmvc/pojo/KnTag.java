package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.Date;

/**  
 * Description：标签图片表
 * @author boyang
 * @date 2019/3/5 19:32
 * @param 
 * @return 
 */
@Repository
public class KnTag {

    private Integer id;

    /**
     *
     名称
     */
    private String title;

    /**
     *
     图片
     */
    private String img;

    /**
     *
     添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}