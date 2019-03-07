package com.springmvc.controller;

import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.springmvc.service.kn_goodsservice;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GoodsController
 * @Description:
 * @Author by
 * @Date: 2019/2/27 15:28
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    final Logger logger = LoggerFactory.getLogger(GoodsController.class);


    @Autowired
    kn_goodsservice knGoodsservice;

    /**
     * Description：得到所有的产品
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/2/27 16:53
     */
    @RequestMapping("getgoodslist")
    @ResponseBody
    public void getDataList(Model model,HttpServletResponse response
    ) {
        List lis = new ArrayList();
        ListObject listObject=new ListObject();
        lis = knGoodsservice.getGoodsList();
        if (lis != null) {
            listObject.setItems(lis);
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("返回数据成功！");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));

        } else {
            listObject.setCode(StatusCode.CODE_ERROR);
            listObject.setMsg("返回数据失败！");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));


        }

    }

}
