package com.springmvc.pojo.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//获取30天的注册人数
public class Regustered {


    private String weeks;

    private Integer count;

    public String getWeeks() {
        return weeks;
    }

    public Integer getCount() {
        return count;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Regustered{" +
                "weeks='" + weeks + '\'' +
                ", count=" + count +
                '}';
    }
}
