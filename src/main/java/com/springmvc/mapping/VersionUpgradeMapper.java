package com.springmvc.mapping;

import com.springmvc.pojo.VersionUpgrade;

import java.util.List;

public interface VersionUpgradeMapper {

    /**
     * @Author 苏俊杰
     * @Description //TODO 根据appid查询最新版本号
     * @Date 13:59 2019/4/15
     * @Param []
     * @return java.util.List<com.springmvc.pojo.VersionUpgrade>
     **/
    List<VersionUpgrade> selectVersionAll(VersionUpgrade version);

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
     * @Date 13:42 2019/4/18
     * @Param
     * @return
     **/
    int deleteVersion(VersionUpgrade versionUpgrade);
    /**
     * @Author 苏俊杰
     * @Description //TODO 编辑版本号
     * @Date 15:34 2019/4/19
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
    List<VersionUpgrade> selectAllVersion();


}
