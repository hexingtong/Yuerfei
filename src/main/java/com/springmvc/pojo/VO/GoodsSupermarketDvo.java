package com.springmvc.pojo.VO;

import com.springmvc.pojo.kn_goods;

import javax.persistence.Column;

public class GoodsSupermarketDvo extends kn_goods {
    @Column(name = "description")
    private String description;//详请描述

    @Column(name = "application_condition")
    private String applicationConditions;//申请条件

    @Column(name = "loop_lines")
    private String loopLiness;//循环额度

    @Column(name = "activation_process")
    private String activationProcesss;//激活流程

    private Integer indexx;

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "GoodsSupermarketDvo{" +
                ", description='" + description + '\'' +
                ", applicationConditions='" + applicationConditions + '\'' +
                ", loopLiness='" + loopLiness + '\'' +
                ", activationProcesss='" + activationProcesss + '\'' +
                ", indexx=" + indexx +
                '}';
    }




    public void setDescription(String description) {
        this.description = description;
    }

    public void setApplicationConditions(String applicationConditions) {
        this.applicationConditions = applicationConditions;
    }

    public void setLoopLiness(String loopLiness) {
        this.loopLiness = loopLiness;
    }

    public void setActivationProcesss(String activationProcesss) {
        this.activationProcesss = activationProcesss;
    }

    public void setIndexx(Integer indexx) {
        this.indexx = indexx;
    }

    public String getApplicationConditions() {

        return applicationConditions;
    }

    public String getLoopLiness() {
        return loopLiness;
    }

    public String getActivationProcesss() {
        return activationProcesss;
    }

    public Integer getIndexx() {
        return indexx;
    }
}
