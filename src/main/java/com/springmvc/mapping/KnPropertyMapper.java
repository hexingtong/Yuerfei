package com.springmvc.mapping;

import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.kn_property;
import tk.mybatis.mapper.common.Mapper;

public interface KnPropertyMapper extends Mapper<KnProperty> {



     kn_property selectProperty();

}