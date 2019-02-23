package com.springmvc.service;

import com.springmvc.pojo.kn_admin;

public interface kn_adminservice  extends  BaseService<kn_admin>{

    /**
     * 查询id
     * @param id
     * @return
     */
    kn_admin queryList(Integer id);

}
