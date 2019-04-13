package com.springmvc.service.impl;


import com.springmvc.mapping.VersionUpgradeMapper;
import com.springmvc.pojo.VersionUpgrade;
import com.springmvc.service.VersionUpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public VersionUpgrade selectVersionAll() {
        List<VersionUpgrade> lst=versionupgrademapper.selectVersionAll();
        VersionUpgrade versionUpgrade=new VersionUpgrade();
        for(int i=0;i<lst.size();i++){
            versionUpgrade=lst.get(i);

            if(versionUpgrade.getVersionId()==null||versionUpgrade.getVersionId()==0){
                if(versionUpgrade.getVersionId()>versionUpgrade.getVersionMini()) {
                    int number = versionUpgrade.getVersionMini();
                    if (number < versionUpgrade.getVersionMini()) {
                        number = versionUpgrade.getVersionMini();


                    }
                }else{
                    //大版本号小于版本号
                }
            }else{

            }

        }
        return versionUpgrade;
    }
    
    
    
}
