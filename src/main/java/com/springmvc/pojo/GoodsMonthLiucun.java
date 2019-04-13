package com.springmvc.pojo;

public class GoodsMonthLiucun {
    private String date;

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private Integer value;

    private  Integer totalInstallUser;

    private String[]   retentionRate;

    public void setRetentionRate(String[] retentionRate) {
        this.retentionRate = retentionRate;
    }

    public String[] getRetentionRate() {

        return retentionRate;
    }

    public Integer getTotalInstallUser() {
        return totalInstallUser;
    }

    public void setTotalInstallUser(Integer totalInstallUser) {
        this.totalInstallUser = totalInstallUser;
    }

    public String getDate() {
        return date;
    }

    public Integer getValue() {
        return value;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setValue(Integer value) {
        this.value = value;
    }



}
