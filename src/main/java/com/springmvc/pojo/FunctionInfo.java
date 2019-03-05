package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;

/**
 * Description：权限表
 * @author boyang
 * @date 2019/3/5 19:11
 * @param 
 * @return 
 */
@Repository
public class FunctionInfo {

    private Integer id;

    /**
     * 权限名
     */
    private String function;

    /**
     * 父级id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 连接
     */
    private String url;

    /**
     * 序列号
     */
    @Column(name = "serial_num")
    private Integer serialNum;

    /**
     * 是否折叠，1可0不可
     */
    private Integer accordion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Integer getAccordion() {
        return accordion;
    }

    public void setAccordion(Integer accordion) {
        this.accordion = accordion;
    }
}