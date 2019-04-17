package com.springmvc.pojo.VO;

/**
 * @ClassName Datacountpvuv
 * @Description: 定义计算近31天的pvuv
 * @Author by
 * @Date: 2019/4/15 14:33
 **/
public class Datacountpvuv {
//对应的天数id
    public Integer id;
//
    public  Integer uv;
    public  Integer pv;

    @Override
    public String toString() {
        return "Datacountpvuv{" +
                "id=" + id +
                ", uv=" + uv +
                ", pv=" + pv +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }
}
