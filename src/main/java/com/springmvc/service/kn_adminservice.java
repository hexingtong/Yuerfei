package com.springmvc.service;

import com.springmvc.pojo.kn_admin;

import java.util.List;

public interface kn_adminservice  extends  BaseService<kn_admin>{

    /**
     * 查询id
     * @param id
     * @return
     */
    kn_admin queryList(Integer id);



    /**
     * 根据手机号查询用户信息
     */
    List<kn_admin> queryListPhone(String phone);

    /**
     * 添加手机号和时间
     */
    int insertAndmin(kn_admin kn_admin);

    /**
     * 查询数据库有没有这个用户
     * 根据手机号查询
     */
    int countAndmin(String phone);

    kn_admin queryByid(String phone);
}
