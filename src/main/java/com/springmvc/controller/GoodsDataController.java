package com.springmvc.controller;

import com.springmvc.pojo.Goodspvdata;
import com.springmvc.pojo.Goodsuvdata;
import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.kn_goods;
import com.springmvc.service.GoodsPvDataService;
import com.springmvc.service.GoodsUvDataService;
import com.springmvc.service.kn_goodsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsDataController
 * @Description:  用来完成pv uv 的产品数据展示
 * @Author by
 * @Date: 2019/3/22 15:21
 **/
@Controller
@RequestMapping("/data")
public class GoodsDataController  {

@Autowired
    GoodsPvDataService goodsPvDataService;
@Autowired
    GoodsUvDataService goodsUvDataService;
@Autowired
kn_goodsservice kngoodsservice;




/**
 * Description： 调到
 * @author boyang
 * @date 2019/3/22 16:59
 * @param , id]
 * @return java.lang.String
 */
    @RequestMapping("/supermarkData")
    public String toEdit(Model model, Integer id){
        kn_goods kn_goods=   kngoodsservice.queryById(id);
        model.addAttribute("kn_goods", kn_goods);
        return "supermarkData";
    }




    /**
     * Description： 得到产品一周的pv,uv接口
     * @author boyang
     * @date 2019/3/22 15:32
     * @param
     * @return
     */
    @RequestMapping("/pvuv")
    @ResponseBody
public Map<String ,Object> getpvuv(Integer goodsid){
    //通过id得到所有的pv
        Goodspvdata goodspvdata2=new Goodspvdata();
        goodspvdata2.setGoodid(goodsid);
  //  Goodspvdata goodspvdata= goodsPvDataService.queryById(goodsid);
        List li=new ArrayList();
        li=  goodsPvDataService.queryListByWhere(goodspvdata2);
        Goodspvdata goodspvdata= (Goodspvdata) li.get(0);
    //通过id得到所有的uv
        Goodsuvdata goodsuvdata=new Goodsuvdata();
        goodsuvdata.setGoodsid(goodsid);

        List li2=new ArrayList();
        li2= goodsUvDataService.queryListByWhere(goodsuvdata);
        Goodsuvdata goodsuvdata2 = (Goodsuvdata) li2.get(0);
    //Goodsuvdata goodsuvdata=   goodsUvDataService.queryById(goodsid);
        Map map =new HashMap();
   map.put("goodspvdata",goodspvdata);
    map.put("goodsuvdata",goodsuvdata2);
    return map;
}





}
