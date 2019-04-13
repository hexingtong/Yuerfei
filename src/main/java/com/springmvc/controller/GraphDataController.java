package com.springmvc.controller;

import com.springmvc.pojo.kn_goods;
import com.util.JsonResult;
import com.util.StatusCode;
import com.util.pvDataUtuil.getCountPv;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GraphDataController
 * @Description: 后台首页的
 * @Author by
 * @Date: 2019/4/12 9:23
 **/
@RequestMapping("/homeData")
@Controller
public class GraphDataController {
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
@RequestMapping("/Showadduser")
public JsonResult Showadduser() {
    JsonResult jsonResult=new JsonResult();

    return jsonResult;
}

/**
 * Description： 得到用户活跃数
 * @author boyang
 * @date 2019/4/12 11:45
 * @param
 * @return
 */
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



}
