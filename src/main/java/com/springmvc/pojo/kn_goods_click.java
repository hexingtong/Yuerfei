package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品点击量表
 */
public class kn_goods_click  implements Serializable{
    //id
    private  int id;
    //商品id
    private String ip;
    //添加时间
    private Date add_time;

    @Override
    public String toString() {
        return "kn_goods_click{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", add_time=" + add_time +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public Date getAdd_time() {
        return add_time;
    }
}
