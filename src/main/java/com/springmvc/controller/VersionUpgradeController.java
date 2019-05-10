package com.springmvc.controller;

import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.VersionUpgrade;
import com.springmvc.service.VersionUpgradeService;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Api(value="app版本号controller",tags={"app版本操作接口"})
@Controller
@RequestMapping("/versionUpgrade")
public class VersionUpgradeController {


    @Autowired
    private VersionUpgradeService versionUpgradeService;

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询最新版本号
     * @Date 12:04 2019/4/17
     * @Param
     * @return
     **/
    @ApiOperation(value = "查询最新版本号", httpMethod = "POST", response = VersionUpgrade.class, notes = "查询最新版本号")
    @RequestMapping("/selectVersion")
    public void selectVersionUpgrade(HttpServletResponse response,VersionUpgrade versionUpgradex){
        ListObject listObject=new ListObject();
        //查询时间最新的版本号
        List<VersionUpgrade> lst=versionUpgradeService.selectVersionAll(versionUpgradex);
        listObject.setItems(lst);
        listObject.setCode(StatusCode.CODE_SUCCESS);
        listObject.setMsg("查询成功!");
        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
    }



    /**
     * @Author 苏俊杰
     * @Description //TODO 上传版本号
     * @Date 12:05 2019/4/17
     * @Param
     * @return
     **/
    @ApiOperation(value = "上传版本号", httpMethod = "POST", response = VersionUpgrade.class, notes = "上传版本号")
    @RequestMapping("/insertVersion")
    public void insertVersion(HttpServletResponse response,VersionUpgrade versionUpgrade){
        ListObject listObject=new ListObject();
        int i=versionUpgradeService.insertVersion(versionUpgrade);
        if(i>0){
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("上传成功!");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else {
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            listObject.setMsg("上传失败!");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 删除版本号
     * @Date 12:05 2019/4/17
     * @Param
     * @return
     **/
    @ApiOperation(value = "删除版本号", httpMethod = "POST", response = VersionUpgrade.class, notes = "删除版本号")
    @RequestMapping("/deleteVersion")
    public void deleteVersion(HttpServletResponse response,VersionUpgrade versionUpgrade){
        int i=versionUpgradeService.deleteVersion(versionUpgrade);
        ListObject listObject=new ListObject();
        if(i>0){
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("删除成功!");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else {
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("删除失败!");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }



    /**
     * @Author 苏俊杰
     * @Description //TODO 编辑版本号
     * @Date 12:05 2019/4/17
     * @Param
     * @return
     **/
    @ApiOperation(value = "编辑版本号", httpMethod = "POST", response = VersionUpgrade.class, notes = "编辑版本号")
    @RequestMapping("/updateVersion")
    public void updateVersion(HttpServletResponse response,VersionUpgrade versionUpgrade){
        int i=versionUpgradeService.updateVersion(versionUpgrade);
        ListObject listObject=new ListObject();
        if(i>0){
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("编辑成功!");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else {
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("编辑失败!");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询所有版本号
     * @Date 16:20 2019/4/19
     * @Param
     * @return
     **/
    @ApiOperation(value = "查询版本号", httpMethod = "POST", response = VersionUpgrade.class, notes = "查询版本号")
    @RequestMapping("/selectAll")
    @ResponseBody
    public PageResultInfo selectAllVersion(HttpServletResponse response,
                                 @RequestParam(value = "pageNo", defaultValue = "1",
                                         required = false)
                                         Integer pageNo,
                                 @RequestParam(value = "pageSize", defaultValue = "3000", required = false)
                                             Integer pageSize){
        PageResultInfo resultInfo = versionUpgradeService.selectAllVersion(pageNo,pageSize);
        return resultInfo;
    }




}
