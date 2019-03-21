package com.springmvc.pojo.DTO;

import com.springmvc.pojo.kn_goods;

/**
 * @ClassName GoodsAttributeDto
 * @Description:自定义商户DTO用来封装bean
 * @Author by
 * @Date: 2019/3/8 9:23
 **/

public class GoodsAttributeDto extends kn_goods {
    //属性名字
    private String propertyTitle;

   private  String PropertyTitle;

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }
}
