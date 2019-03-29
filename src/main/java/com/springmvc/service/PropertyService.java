package com.springmvc.service;

import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.kn_property;

/**
 * Description：商品属性表
 * @author boyang
 * @date 2019/3/7 12:05
 * @param
 * @return
 */
public interface PropertyService  extends  BaseService<KnProperty>{

    kn_property selectProperty();
}
