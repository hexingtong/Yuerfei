package com.springmvc.controller;

import com.springmvc.pojo.ArticeSupper;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.service.CommunityService;
import com.util.JsonResult;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Api(value="App社区页面controller",tags={"社区操作接口"})
@Controller
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    CommunityService communityService;
    /**
     * @Author 苏俊杰
     * @Description //TODO 社区展示列表
     * @Date 17:05 2019/4/25
     * @Param
     * @return
     **/
    @ApiOperation(value = "获取全部帖子AND获得审核成功的帖子", httpMethod = "POST", response = ArticeSupper.class, notes = "index=1(就查询审核成功的帖子),index=0(查询全部的帖子)")
    @RequestMapping("/communityList")
    @ResponseBody
    public JsonResult Community(@RequestParam(value = "pageNo", defaultValue = "1",
                                            required = false)
                                            Integer pageNo,
                                @RequestParam(value = "pageSize", defaultValue = "5", required = false)
                                            Integer pageSize,ArticeSupper articeSupper){
        JsonResult result=new JsonResult();
        if(null==articeSupper.getIndex()){
            result.setCode(StatusCode.CODE_NULL);
            result.setMessage("is no ok because index is null");
            return result;
        }
        PageResultInfo pageResultInfo=communityService.selectCommunity(pageNo,pageSize,articeSupper);
        result.setCode(StatusCode.SUCCESSFULLY);
        result.setMessage("查询成功");
        result.setData(pageResultInfo);
//        result.setResult(JsonResult.ResultStatus.success);
        return result;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 查看我的帖子
     * @Date 13:58 2019/4/26
     * @Param
     * @return
     **/
    @ApiOperation(value = "查看我的全部帖子", httpMethod = "POST", response = ArticeSupper.class, notes = "需要adminid参数")
    @RequestMapping("/selectMyCommunity")
    @ResponseBody
    public JsonResult selectMyCommunity(@RequestParam(value = "pageNo", defaultValue = "1",
                                                     required = false)
                                                    Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "5", required = false)
                                                    Integer pageSize,ArticeSupper articeSupper){
        JsonResult result=new JsonResult();
        PageResultInfo pageResultInfo=communityService.selectMyCommunity(pageNo,pageSize,articeSupper);
        if(null==pageResultInfo||pageResultInfo.getTotal()==0){
            result.setCode(StatusCode.CODE_NULL);
            result.setMessage("is ok but no result");
            return result;
        }else {
            result.setMessage("查询成功");
            result.setCode(StatusCode.SUCCESSFULLY);
            result.setData(pageResultInfo);
            return result;
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 删除我的帖子
     * @Date 14:01 2019/4/26
     * @Param
     * @return
     **/
    @RequestMapping("/deleteMyCommunity")
    @ResponseBody
    public JsonResult deleteMyCommunity(ArticeSupper articeSupper){
       JsonResult result=new JsonResult();

       return result;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 查看具体的帖子信息
     * @Date 17:22 2019/4/26
     * @Param
     * @return
     **/
    @RequestMapping("/selectOneCommunity")
    @ResponseBody
    public JsonResult selectOneCommunity(){
        JsonResult jsonResult=new JsonResult();

        return jsonResult;
    }

}
