package com.springmvc.service;

import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.VersionUpgrade;

import java.util.List;

/**
 * @Author 苏俊杰
 * @Description //TODO app版本号控制
 * @Date 10:48 2019/4/12
 * @Param 
 * @return 
 **/
public interface VersionUpgradeService {

    /**
     * @Author 苏俊杰
     * @Description //TODO 根据时间查询最新版本号
     * @Date 13:38 2019/4/17
     * @Param []
     * @return com.springmvc.pojo.VersionUpgrade
     **/
    VersionUpgrade selectVersionAll(VersionUpgrade versionUpgrade);

    /**
     * @Author 苏俊杰
     * @Description //TODO 上传版本号
     * @Date 11:34 2019/4/18
     * @Param
     * @return
     **/
    int insertVersion(VersionUpgrade versionUpgrade);
    /**
     * @Author 苏俊杰
     * @Description //TODO 删除版本号
     * @Date 12:05 2019/4/17
     * @Param
     * @return
     **/
    int deleteVersion(VersionUpgrade versionUpgrade);
    /**
     * @Author 苏俊杰
     * @Description //TODO 编辑版本号
     * @Date 15:35 2019/4/19
     * @Param
     * @return
     **/
    int updateVersion(VersionUpgrade versionUpgrade);
    /**
     * @Author 苏俊杰
     * @Description //TODO 查询所有版本号
     * @Date 16:19 2019/4/19
     * @Param
     * @return
     **/
    PageResultInfo selectAllVersion(Integer pageNo, Integer pageSize);

}
