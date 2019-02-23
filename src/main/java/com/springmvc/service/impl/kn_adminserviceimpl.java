package com.springmvc.service.impl;

import com.springmvc.mapping.kn_adminMapper;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.kn_adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

@Service
public class kn_adminserviceimpl  extends BaseServiceImpl<kn_admin> implements kn_adminservice  {

@Autowired
private kn_adminMapper adminMapper;

    public kn_admin queryList(Integer id) {
        kn_admin knAdmin=adminMapper.queryList(id);
        return knAdmin;
    }


}
