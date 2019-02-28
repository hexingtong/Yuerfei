package com.springmvc.mapping;

import com.springmvc.pojo.kn_admin;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface kn_adminMapper  extends Mapper<kn_admin>{

    kn_admin queryList(Integer id);

    List<kn_admin> queryListPhone(String phone);

    int insertAndmin(kn_admin kn_admin);

    int countAndmin(String phone);
    kn_admin queryByid(String phone);
}