package com.springmvc.pojo.VO;

import com.springmvc.pojo.KnGoods;

/**
 * @ClassName TenantGoodsVO
 * @Description: 用来接收商户产品数据的VO
 * @Author by
 * @Date: 2019/3/8 16:23
 **/
public class TenantGoodsVO extends KnGoods {
    //详请描述;
    private String description;
    //客服电话
    private String servicePhone;
    //企业认证
    private String businessAuthentication;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public String getBusinessAuthentication() {
        return businessAuthentication;
    }

    public void setBusinessAuthentication(String businessAuthentication) {
        this.businessAuthentication = businessAuthentication;
    }
}
