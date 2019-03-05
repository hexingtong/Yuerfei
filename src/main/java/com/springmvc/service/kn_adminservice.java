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
     *
     */
    int countAndmin(String phone);

    /**
     * 根据手机号查到id值
     * @param phone
     * @return
     */
    kn_admin queryByid(String phone);

    /**
     * 根据id 修改最近登录时间
     */
    int UpdateLoginTime(kn_admin kn_admin);


    /**
     * Description：通过用户名得到用户信息(id，密码）
     * @author boyang
     * @date 2019/3/4 16:48
     * @param
     * @return
     */
    kn_admin queryByPhone(String phone);

}
