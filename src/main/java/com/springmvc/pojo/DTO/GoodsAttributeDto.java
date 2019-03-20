package com.springmvc.pojo.DTO;

import com.springmvc.pojo.KnGoods;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName GoodsAttributeDto
 * @Description:自定义商户DTO用来封装bean
 * @Author by
 * @Date: 2019/3/8 9:23
 **/

public class GoodsAttributeDto extends KnGoods {
    //属性名字
    private String propertyTitle;

   private  String statusName;

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
