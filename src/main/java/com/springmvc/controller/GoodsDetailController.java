package com.springmvc.controller;

import com.springmvc.pojo.GoodsDetail;
import com.springmvc.service.GoodsDetailService;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Api(value="产品详情controller",tags={"获取产品详情"})
@Controller
@RequestMapping("/goodsDetail")
public class GoodsDetailController {

    @Autowired
    GoodsDetailService goodsDetailService;
    
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 获取产品详情
     * @Date 14:46 2019/4/8
     * @Param [response, id]
     * @return void
     **/
    @ApiOperation(value = "获取产品详情", httpMethod = "POST", response = StatusCode.class, notes = "获取产品详情")
    @RequestMapping("/selectDetail")
    public void selectDetail(HttpServletResponse response, String  id){
        ListObject listObject = new ListObject();
        if(!id.equals("")&&id!=null) {
            GoodsDetail goodsDetail = goodsDetailService.selectDetail(Integer.parseInt(id));
            List lst = new ArrayList();
            lst.add(goodsDetail);
            listObject.setItems(lst);
            listObject.setMsg("查询成功");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else{
            listObject.setMsg("查询失败");
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }


}
