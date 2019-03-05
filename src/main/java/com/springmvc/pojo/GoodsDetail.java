package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;

/**
 * Description：产品详情表
 * @author boyang
 * @date 2019/3/5 19:14
 * @param 
 * @return 
 */
@Repository
public class GoodsDetail {

    private Integer id;

    /**
     详请描述
     */
    private String description;

    /**
     *
     申请条件
     */
    @Column(name = "application_condition")
    private String applicationCondition;

    /**
     循环额度
     */
    @Column(name = "loop_lines")
    private String loopLines;

    /**
     *
     激活流程
     */
    @Column(name = "activation_process")
    private String activationProcess;

    /**
     *
     企业认证
     */
    @Column(name = "business_authentication")
    private String businessAuthentication;

    /**
     *
     客服电话
     */
    @Column(name = "service_phone")
    private String servicePhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplicationCondition() {
        return applicationCondition;
    }

    public void setApplicationCondition(String applicationCondition) {
        this.applicationCondition = applicationCondition;
    }

    public String getLoopLines() {
        return loopLines;
    }

    public void setLoopLines(String loopLines) {
        this.loopLines = loopLines;
    }

    public String getActivationProcess() {
        return activationProcess;
    }

    public void setActivationProcess(String activationProcess) {
        this.activationProcess = activationProcess;
    }

    public String getBusinessAuthentication() {
        return businessAuthentication;
    }

    public void setBusinessAuthentication(String businessAuthentication) {
        this.businessAuthentication = businessAuthentication;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }
}