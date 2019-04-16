package com.springmvc.service.impl;


import com.springmvc.mapping.VersionUpgradeMapper;
import com.springmvc.pojo.VersionUpgrade;
import com.springmvc.service.VersionUpgradeService;
import com.util.DateUtil;
import com.util.VersionUpgradeUtil.VersionUpgradeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VersionUpgradeServiceImpl implements VersionUpgradeService{


    @Autowired
     VersionUpgradeMapper versionupgrademapper;
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 版本号更新
     * @Date 11:53 2019/4/12
     * @Param []
     * @return com.springmvc.pojo.VersionUpgrade
     **/
    @Override
    public VersionUpgrade selectVersionAll(VersionUpgrade version) {

        return version;
    }
    
    
    
}
