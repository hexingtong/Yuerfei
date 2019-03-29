package com.springmvc.pojo;

public class Person {
    //短链接的json pojo
    private int id;
    //天数
    private String day;
    //pv
    private String visitCount;
    //uv
    private String uv;

    public int getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public String getVisitCount() {
        return visitCount;
    }

    public String getUv() {
        return uv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setVisitCount(String visitCount) {
        this.visitCount = visitCount;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }
}
