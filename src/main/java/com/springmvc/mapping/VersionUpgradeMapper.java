package com.springmvc.mapping;

import com.springmvc.pojo.VersionUpgrade;

import java.util.List;

public interface VersionUpgradeMapper {

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询所有版本号
     * @Date 13:59 2019/4/15
     * @Param []
     * @return java.util.List<com.springmvc.pojo.VersionUpgrade>
     **/
    List<VersionUpgrade> selectVersionAll(VersionUpgrade version);

    /**
     * @Author 苏俊杰
     * @Description //TODO 根据版本号大小返回
     * @Date 13:59 2019/4/15
     * @Param 
     * @return 
     **/


}
