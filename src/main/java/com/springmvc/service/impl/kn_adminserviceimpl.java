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

    public List<kn_admin> queryListPhone(String phone){
        List<kn_admin> kn_Admin=adminMapper.queryListPhone(phone);
        return kn_Admin;
    }

    public int insertAndmin(kn_admin kn_admin){
        int kn_Admin=adminMapper.insertAndmin(kn_admin);
        return kn_Admin;
    }

    public int countAndmin(String phone){
        int kn_Admin=adminMapper.countAndmin(phone);
        return kn_Admin;
    }
    public kn_admin queryByid(String phone){
        kn_admin knAdmin=adminMapper.queryByid(phone);
        return knAdmin;
    }
    public int UpdateLoginTime(kn_admin kn_admin){
        int knadmin=adminMapper.UpdateLoginTime(kn_admin);
        return knadmin;
    }

}
