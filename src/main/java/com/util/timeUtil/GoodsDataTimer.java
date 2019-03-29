package com.util.timeUtil;

import com.springmvc.pojo.VO.paramInfos;
import com.springmvc.service.GoodsPvDataService;
import com.springmvc.service.GoodsUvDataService;
import com.util.OpenAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Calendar;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName GoodsDataTimer
 * @Description: 产品定时更新pv uv每个小时跟新一次
 * @Author by
 * @Date: 2019/3/25 11:50
 **/
@Controller
public class GoodsDataTimer  {
    @Autowired
    GoodsPvDataService goodsPDataService;

@Autowired
GoodsUvDataService goodsUvDataService;

    Calendar twentyOne = Calendar.getInstance();
    // 第三种方法：设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
    // scheduleAtFixedRate(TimerTask task, long delay, long period)

    public static void timer3() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
//
//                OpenAPI.umengAndroidPvEventParamGetValueList();
//                OpenAPI.umengAndroidEventParamGetValueList();
//                paramInfos o= (paramInfos) OpenAPI.umengAndroidPvEventParamGetValueList().get(0);
//
//                //paramInfos
//                //for (int i=0;i<)







            }
        }, 1000, 2000);
    }
    public static void main(String[] args) {
//        paramInfos o= (paramInfos) OpenAPI.umengAndroidPvEventParamGetValueList().get(0);
//        System.out.println(o.getName());
    }


}
