package com.springmvc.controller;

import com.springmvc.pojo.Goodspvdata;
import com.springmvc.pojo.Goodsuvdata;

import com.springmvc.pojo.kn_goods;
import com.springmvc.service.GoodsPvDataService;
import com.springmvc.service.GoodsUvDataService;
import com.springmvc.service.kn_goodsservice;
import com.util.pvDataUtuil.getCountPv;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;


import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsDataController
 * @Description: 用来完成pv uv 的产品数据展示
 * @Author by
 * @Date: 2019/3/22 15:21
 **/
@Controller
@RequestMapping("/data")
public class GoodsDataController {
    final Logger logger = LoggerFactory.getLogger(GoodsController.class);


    @Autowired
    GoodsPvDataService goodsPvDataService;
    @Autowired
    GoodsUvDataService goodsUvDataService;
    @Autowired
    kn_goodsservice kngoodsservice;


    /**
     * Description： 调到
     *
     * @param , id]
     * @return java.lang.String
     * @author boyang
     * @date 2019/3/22 16:59
     */
    @RequestMapping("/supermarkData")
    public String toEdit(Model model, Integer id) {
        System.out.println("进入supermarkda+" + id);
        kn_goods kn_goods = kngoodsservice.queryById(id);
        model.addAttribute("kn_goods", kn_goods);
        return "supermarkData";
    }


    /**
     * Description： 得到产品一周的pv,uv接口
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/22 15:32
     */
    @RequestMapping("/pvuv")
    public String getpvuv(Model model, Integer goodsid) {
        //通过id得到所有的pv
        Goodspvdata goodspvdata = goodsPvDataService.queryById(goodsid);
        //通过id得到所有的uv
        Goodsuvdata goodsuvdata = goodsUvDataService.queryById(goodsid);
        model.addAttribute("goodspvdata", goodspvdata);
        model.addAttribute("goodsuvdata", goodsuvdata);
        return "supermarkData";
    }


    /**
     * Description：定时更新总的pvuv
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/26 18:55
     */
@Scheduled(cron= "0 0 0/2 * * ? ")
    public void getpvuv() {
        logger.info("更新pvuv定时任务");
        goodsPvDataService.unCountPv();
        goodsUvDataService.unCountUv();


    }

    /**
     * Description： 定时清空pvuv
     * @param
     * @return
     * @author boyang
     * @date 2019/4/2 11:47
     */
    @Scheduled(cron= "* 55 23 * * 1")
    @RequestMapping("/delepvuv")
    public void delepvuv() {
        logger.info("删除pvuv定时任务");
            goodsPvDataService.delePv();
            goodsUvDataService.deleUv();


    }

/**
 * Description：定时把pvuv加到对应的产品
 * @author boyang
 * @date 2019/4/2 11:52
 * @param
 * @return
 */
@RequestMapping("/upPvUv")
 public void upPvUv(){
     //
     kngoodsservice.updateGoodspvuv();


 }

}
