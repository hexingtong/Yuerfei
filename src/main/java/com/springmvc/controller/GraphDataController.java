package com.springmvc.controller;

import com.springmvc.mapping.kn_goodsMapper;
import com.springmvc.pojo.Person;
import com.springmvc.pojo.kn_goods;
import com.springmvc.service.FriendTimer;
import com.springmvc.service.PvUvDataService;
import com.springmvc.service.kn_goodsservice;
import com.util.JsonResult;
import com.util.StatusCode;
import com.util.pvDataUtuil.getCountPv;
import com.util.redis.impl.RedisPoolService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @ClassName GraphDataController
 * @Description: 后台首页的
 * @Author by
 * @Date: 2019/4/12 9:23
 **/
@RequestMapping("/homeData")
@Controller
public class GraphDataController {

    @Autowired
    private PvUvDataService pa;
/**
 * Description： 得到产品总的pvuv
 * @author boyang
 * @date 2019/4/12 10:32
 * @param
 * @return java.lang.String
 */
    @RequestMapping("/ShowPvUv")
    public JsonResult toShowPvUv() {
        JsonResult jsonResult=new JsonResult();

        return jsonResult;
    }
/**  
 * Description： 得到留存
 * @author boyang
 * @date  10:54
 * @param 
 * @return 
 */
@ApiOperation(value = "得到留存", httpMethod = "POST", response = StatusCode.class, notes = "得到留存")
@RequestMapping("/Showkeep")
@ResponseBody
public JsonResult Showkeep() {
    JsonResult jsonResult=new JsonResult();
    try {
        jsonResult.setData(getCountPv.getThreeGetRetentions());
    } catch (Exception e) {
        e.printStackTrace();
        jsonResult.setResult(JsonResult.ResultStatus.fail);

    }
    jsonResult.setResult(JsonResult.ResultStatus.success);
    return jsonResult;
}
/**
 * Description：得到新增用户
 * @author boyang
 * @date 2019/4/12 11:45
 * @param
 * @return
 */
@ApiOperation(value = "新增用户", httpMethod = "POST", response = StatusCode.class, notes = "新增用户")
@RequestMapping("/Showadduser")
@ResponseBody
public JsonResult Showadduser() {
    JsonResult jsonResult=new JsonResult();

    try {
        jsonResult.setData(getCountPv.getMonthnewUser());
    } catch (Exception e) {
        jsonResult.setResult(JsonResult.ResultStatus.fail);
        e.printStackTrace();
    }
    jsonResult.setResult(JsonResult.ResultStatus.success);
    return jsonResult;
}

/**
 * Description： 得到用户活跃数
 * @author boyang
 * @date 2019/4/12 11:45
 * @param
 * @return
 */
@ApiOperation(value = "用户活跃数", httpMethod = "POST", response = StatusCode.class, notes = "用户活跃数")
@RequestMapping("/Showativeruser")
@ResponseBody
public JsonResult Showativeruser() {
    JsonResult jsonResult=new JsonResult();
    try {
        jsonResult.setData(getCountPv.getMonthActive());
    } catch (Exception e) {
        jsonResult.setResult(JsonResult.ResultStatus.fail);
        e.printStackTrace();
    }
    jsonResult.setResult(JsonResult.ResultStatus.success);
    return jsonResult;
}
/**
 * Description：从短链接中拉取近三十天产品总的pv uv
 * @author boyang
 * @date 2019/4/15 10:33
 * @param
 * @return void
 */
@ApiOperation(value = "得到产品总三十天的pvuv", httpMethod = "POST", response = StatusCode.class, notes = "得到产品总三十天的pvuv数")
@RequestMapping("/ShowPvUv2")
@ResponseBody
public JsonResult getMonthpvuv() {
    JsonResult jsonResult=new JsonResult();
    try {
        jsonResult.setData(pa.getcountPvUv());
    } catch (Exception e) {
        jsonResult.setResult(JsonResult.ResultStatus.fail);
        e.printStackTrace();
    }
    jsonResult.setResult(JsonResult.ResultStatus.success);
    return jsonResult;

}


}
