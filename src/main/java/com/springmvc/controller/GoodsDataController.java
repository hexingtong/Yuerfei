package com.springmvc.controller;

import com.springmvc.mapping.kn_goodsMapper;
import com.springmvc.mapping.kn_goodsMapper;
import com.springmvc.pojo.Goodspvdata;
import com.springmvc.pojo.Goodsuvdata;

import com.springmvc.pojo.kn_goods;
import com.springmvc.service.FriendTimer;
import com.springmvc.service.GoodsPvDataService;
import com.springmvc.service.GoodsUvDataService;
import com.springmvc.service.kn_goodsservice;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import com.util.pvDataUtuil.getCountPv;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
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
@ApiIgnore()
@Controller
@RequestMapping("/data")
public class GoodsDataController {
    final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Autowired
    private kn_goodsservice knGoodsservice;
    @Autowired
    private kn_goodsMapper knGoodsMapper;

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
//@Scheduled(cron= "0 0/1 * * * ? ")
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
 //   @Scheduled(cron= "* 55 23 * * 1")
    @RequestMapping("/delepvuv")
    public void delepvuv() {
        logger.info("删除pvuv定时任务");
            goodsPvDataService.delePv();
            goodsUvDataService.deleUv();


    }

/**
 * Description：定时把短链接pvuv加到对应的产品
 * @author boyang
 * @date 2019/4/2 11:52
 * @param
 * @return
 */
//@Scheduled(cron= "0 0/6 * * * ? ")
@RequestMapping("/upPvUv")
 public void upPvUv() {
    logger.info("进入更新产品pvuv");
    //getCountPv.getUv2();
    kngoodsservice.updateGoodspvuv();

}
    /**
     * Description： 定时更新产品总的pvuv
     * @author boyang
     * @date 2019/4/13 15:34
     * @param
     *
     * @return
     * @return
     */
    @Scheduled(cron= "0 0/2 * * * ? ")
    public void unpvuvdfdf(){
        ListObject listObject=new ListObject();
        System.out.println("拿取数据");
        String format="visitor";

        List<kn_goods> lst=knGoodsservice.getGoodsList();
        Map map=new HashMap();
        for(int i=0;i<lst.size();i++){
            kn_goods kn_friend=new kn_goods();
            kn_friend=lst.get(i);
            System.out.println("查询的id"+kn_friend.getId());
            System.out.println("查询的url"+kn_friend.getShortUrl());
            map= FriendTimer.Totalpvuv(kn_friend.getShortUrl(),format);
            String success=(String) map.get("success");
            System.out.println("success的值"+success);
            if(success.equals("ok")) {
                System.out.println("进入update");
                Integer pv=Integer.parseInt(map.get("pv").toString());
                Integer uv=Integer.parseInt(map.get("uv").toString());
                System.out.println("转换后的uv值"+uv);
                System.out.println("转换后的pv值"+pv);
                kn_friend.setUv(uv);
                kn_friend.setPv(pv);
                kn_friend.setId(lst.get(i).getId());
                System.out.println("对象里有没有id值"+kn_friend.toString());
                try {
                    knGoodsMapper.updateOnepvuv(kn_friend);
                } catch (Exception e) {
                    System.out.println("编辑失败");
                    listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                    listObject.setMsg("编辑失败");

                    e.printStackTrace();
                }

            }else{
                listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                listObject.setMsg("上传链接失败");

            }
        }
        listObject.setCode(StatusCode.CODE_SUCCESS);
        listObject.setMsg("编辑成功");

        System.out.println("-----------------拿取结束-----------------");

    }
}
