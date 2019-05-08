package com.springmvc.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.VersionUpgradeMapper;
import com.springmvc.pojo.DTO.GoodsAttributeDto;
import com.springmvc.pojo.PageResultInfo;
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
    public List<VersionUpgrade> selectVersionAll(VersionUpgrade versionUpgrade) {
        List<VersionUpgrade> versionUpgradex=versionupgrademapper.selectVersionAll(versionUpgrade);
        return versionUpgradex;

    }

    @Override
    public int insertVersion(VersionUpgrade versionUpgrade) {
        versionUpgrade.setCreateTime(new Date());
        int i=versionupgrademapper.insertVersion(versionUpgrade);
        if(i>0){
            return i;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteVersion(VersionUpgrade versionUpgrade) {
        int i=versionupgrademapper.deleteVersion(versionUpgrade);
        if(i>0){
            return i;
        }
        return 0;
    }

    @Override
    public int updateVersion(VersionUpgrade versionUpgrade) {
        versionUpgrade.setUpdateTime(new Date());
        int i=versionupgrademapper.updateVersion(versionUpgrade);
        return i;
    }

    @Override
    public PageResultInfo selectAllVersion(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<VersionUpgrade> lst=versionupgrademapper.selectAllVersion();
        PageInfo<VersionUpgrade> pageInfo = new PageInfo<>(lst);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());

        return resultInfo;
    }

}
