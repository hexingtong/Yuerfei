package com.springmvc.service.impl;

import com.springmvc.mapping.KnPropertyMapper;
import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.kn_property;
import com.springmvc.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description：商品属性表
 * @author boyang
 * @date 2019/3/7 12:05
 * @param
 * @return
 */
@Service
public class PropertyServiceImpl extends BaseServiceImpl<KnProperty> implements PropertyService {

    @Autowired
    private KnPropertyMapper knPropertyMapper;

    @Override
    public kn_property selectProperty() {
        kn_property kn_property=knPropertyMapper.selectProperty();
        return kn_property;
    }
}
