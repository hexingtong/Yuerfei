package com.springmvc.controller;

import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.KnTag;
import com.springmvc.pojo.Statusputaway;
import com.springmvc.service.KnTagService;
import com.springmvc.service.PropertyService;
import com.springmvc.service.StatusputawayService;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.springmvc.service.kn_goodsservice;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import io.swagger.annotations.ApiOperation;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsController
 * @Description:
 * @Author 苏俊杰
 * @Date:
 **/
@Controller
@RequestMapping("/Goods")
public class GoodsController {

    final Logger logger = LoggerFactory.getLogger(GoodsController.class);




    @Autowired
    kn_goodsservice knGoodsservice;
    @Autowired
    PropertyService propertyService;

    @Autowired
    StatusputawayService  statusputawayService;

    @Autowired
    KnTagService knTagService;

    /**
     * Description：得到商家所有的产品
     *
     * @param
     * @return
     * @author 苏俊杰
     * @date 2019/2/27 16:53
     */
    @RequestMapping("getGoodsList")
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

    /**
     * Description：商家产品属性接口
     * @author 苏俊杰
     * @date 2019/3/8 15:19
     * @param
     * @return
     */
    @RequestMapping("getAttributelist")
    @ResponseBody
    public Map<String,List<KnProperty>> getPropertyList( HttpServletResponse response
    ) {
        Map<String,List<KnProperty>>map=new HashMap<String,List<KnProperty>>();

        map.put("property",propertyService.queryAll());
        return map;
    }

    /**
     * Description：商家产品上架状态接口
     * @author 苏俊杰
     * @date 2019/3/8 15:19
     * @param
     * @return
     */
    @RequestMapping("getStatuslist")
    @ResponseBody
    public Map<String,List<Statusputaway>> getPutawayList( HttpServletResponse response
    ) {
        Map<String,List<Statusputaway>>map=new HashMap<String,List<Statusputaway>>();
        map.put("Statusputaway",statusputawayService.queryAll());
        return map;
    }
    /**
     * Description：商家产品标签接口
     * @author 苏俊杰
     * @date 2019/3/8 15:19
     * @param
     * @return
     */
    @RequestMapping("getTaglist")
    @ResponseBody
    public Map<String,List<KnTag>> getTaglist( HttpServletResponse response
    ) {
        Map<String,List<KnTag>>map=new HashMap<String,List<KnTag>>();
        map.put("KnTag",knTagService.queryAll());
        return map;
    }

}
