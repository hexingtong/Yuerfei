package com.springmvc.controller;

import com.aliyuncs.utils.StringUtils;
import com.springmvc.pojo.DTO.knadmin2;
import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.RoleInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.ManagementService;
import com.springmvc.service.RoleInfoService;
import com.springmvc.service.kn_adminservice;
import com.util.IPutil;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ManagementController
 * @Description: 管理人员列表
 * @Author by
 * @Date: 2019/3/9 13:48
 **/

@Api(value="管理人员controller",tags={"管理人员操作接口"})
@Controller
@RequestMapping("/Manage")
public class ManagementController {


@Autowired
ManagementService managementService;
@Autowired
kn_adminservice knAdminservice;
@Autowired
    RoleInfoService roleInfoService;


    final Logger logger = LoggerFactory.getLogger(MemberController.class);


    /**
     * Description：到编辑管理人员页面
     * @author boyang
     * @date 2019/3/18 17:09
     * @param
     * @return
     */
    @ApiIgnore()
    @RequestMapping("toEdit")
    public String toEdit(Model model, Integer id) {
       kn_admin knAdmin= managementService.queryById(id);
      RoleInfo roleInfo= roleInfoService.queryById( knAdmin.getLevel());
        knadmin2  ken=new knadmin2();
        ken.setTitle(knAdmin.getTitle());
        ken.setImg(knAdmin.getImg());
        ken.setPhone(knAdmin.getPhone());
        ken.setRoleName(roleInfo.getRoleName());
        ken.setPwd(knAdmin.getPwd());
        model.addAttribute("knadmin2", ken);
        model.addAttribute("knAdmin", knAdmin);
        model.addAttribute("roleInfo", roleInfo);
        return "managementEditor";
    }
/**
 * Description：跳到新增
 * @author boyang
 * @date 2019/3/19 9:45
 * @param
 * @return
 */
@ApiIgnore()
@RequestMapping("toAdd")
public String toAdd(Model model, Integer id) {
return "managementAdd";
}

    /**
     * Description：, pageNo：当前页, pageSize：页容量,传入的手机号
     * @author boyang
     * @date 2019/3/7 11:04
     * @param response, pageNo, pageSize, 不做查询分页]
     * @return com.springmvc.pojo.PageResultInfo
     */
    @ApiOperation(value = "获取管理人员数据", httpMethod = "POST", response = StatusCode.class, notes = "获取管理人员数据")
    @RequestMapping("/getManageList")
    @ResponseBody
    public PageResultInfo getDataList(Model model, HttpServletResponse response,
                                        @RequestParam(value = "pageNo", defaultValue = "1",
                                                required = false)
                                                Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "30000", required = false)
                                                Integer pageSize,

    String phone) {
        logger.info("传入的pageno,pagesize,phone"+pageNo+":"+pageSize+":"+phone);
        PageResultInfo resultInfo = managementService.queryManagementList(pageNo, pageSize,phone);
        return  resultInfo;


    }
/*
 * Description：新增管理员接口
 * @author boyang
 * @date 2019/3/9 16:04
 * @param
 * @return
 */
@ApiOperation(value = "新增管理员接口", httpMethod = "POST", response = StatusCode.class, notes = "新增管理员接口")
@RequestMapping("/AddManage")
@ResponseBody
public int saveManagement(@RequestBody kn_admin knAdmin, HttpServletRequest request){
    if (!StringUtils.isEmpty(knAdmin.getPhone())&&!"".equals(knAdmin.getPhone())){

                if( knAdminservice.queryByid(knAdmin.getPhone())==null){
                    knAdmin.setAddTime(new Date());
                    try {
                        managementService.saveSelective(knAdmin);
                        //    int i= managementService.saveManment(knAdmin);
                        return 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return 0;
                    }
                }else {
                     return -2;
                }


    }else {
        managementService.updateSelectiveById(knAdmin);
        return -1;
    }


}

/**  
 * Description：编辑管理人员列表
 * @author boyang
 * @date 2019/3/11 9:04
 * @param 
 * @return 
 */
@ApiOperation(value = "编辑管理人员列表", httpMethod = "POST", response = StatusCode.class, notes = "编辑管理人员列表")
@RequestMapping("/saveManagement")
    @ResponseBody()
    public int updateManagement(@RequestBody kn_admin knAdmin, HttpServletRequest request){
    if(knAdmin!=null){
        try {
            managementService.updateSelectiveById(knAdmin);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }else {
        return -1;
    }
    }


}
