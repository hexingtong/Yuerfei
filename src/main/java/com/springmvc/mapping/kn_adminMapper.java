package com.springmvc.mapping;

import com.springmvc.pojo.kn_admin;
import tk.mybatis.mapper.common.Mapper;

public interface kn_adminMapper  extends Mapper<kn_admin>{

    kn_admin queryList(Integer id);


}