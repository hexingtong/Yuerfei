package com.springmvc.controller;


import com.springmvc.pojo.VersionUpgrade;
import com.springmvc.service.VersionUpgradeService;
import com.util.VersionUpgradeUtil.VersionUpgradeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore()
@Controller
@RequestMapping("/AppUpdate")
public class AppUpdateController {

        @Autowired
        private VersionUpgradeService versionUpgradeService;






    /**
     * @Author 苏俊杰
     * @Description //TODO 查询版本号
     * @Date 9:32 2019/4/12
     * @Param 
     * @return 
     **/
        @RequestMapping("/compareVersion")
        public void compareVersion(VersionUpgrade version) {


        }

    
}
