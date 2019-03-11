package com.springmvc.controller;

import com.aliyuncs.utils.StringUtils;
import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.ManagementService;
import com.springmvc.service.kn_adminservice;
import com.util.IPutil;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ManagementController
 * @Description: 管理人员列表
 * @Author by
 * @Date: 2019/3/9 13:48
 **/
@Controller
@RequestMapping("/Manage")
public class ManagementController {


@Autowired
ManagementService managementService;
@Autowired
kn_adminservice knAdminservice;



    final Logger logger = LoggerFactory.getLogger(MemberController.class);

    /**
     * Description：, pageNo：当前页, pageSize：页容量,传入的手机号
     * @author boyang
     * @date 2019/3/7 11:04
     * @param response, pageNo, pageSize, 不做查询分页]
     * @return com.springmvc.pojo.PageResultInfo
     */
    @RequestMapping("/getManageList")
    @ResponseBody
    public PageResultInfo getDataList(Model model, HttpServletResponse response,
                                        @RequestParam(value = "pageNo", defaultValue = "1",
                                                required = false)
                                                Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "3", required = false)
                                                Integer pageSize,

    String phone) {
        logger.info("传入的pageno,pagesize,phone"+pageNo+":"+pageSize+":"+phone);
        PageResultInfo resultInfo = managementService.queryManagementList(pageNo, pageSize,phone);
        return  resultInfo;


    }
/*
 * Description：新增管理员接口
 * @author boyang(未测）
 * @date 2019/3/9 16:04
 * @param
 * @return
 */
@RequestMapping("/getManagementList")
@ResponseBody
public int saveManagement(@RequestBody kn_admin knAdmin, HttpServletRequest request){
    if (StringUtils.isEmpty(knAdmin.getPhone())&&"".equals(knAdmin.getPhone())){
        int i= managementService.saveManment(knAdmin);

         }

       return 1;


}

/**  
 * Description：编辑管理人员列表
 * @author boyang
 * @date 2019/3/11 9:04
 * @param 
 * @return 
 */
@RequestMapping("/saveManagement")
    @ResponseBody()
    public int updateManagement(@RequestBody kn_admin knAdmin, HttpServletRequest request){
    if(knAdmin.getId()!=null){
        managementService.updateSelectiveById(knAdmin);


    }
    return 1;

}


}
