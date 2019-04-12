package com.springmvc.service;

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


    VersionUpgrade selectVersionAll();
}
