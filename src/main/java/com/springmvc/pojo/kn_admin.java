package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public class kn_admin  implements Serializable{
 private Integer id;
 private String title;
 private  int phone;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPhone() {
        return phone;
    }
}