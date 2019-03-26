package com.util.timeUtil;

import com.util.OpenAPI;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Calendar;
import java.util.Timer;

/**
 * @ClassName TimerDataTaskListener
 * @Description: 创建监听器类
 * @Author by
 * @Date: 2019/3/25 11:04
 **/
public class TimerDataTaskListener implements ServletContextListener {
    private Timer timer = null;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        OpenAPI configService = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()).getBean(OpenAPI.class);

        TimerUtils timerUtils=new TimerUtils();
        timerUtils.timer3();
        //System.out.println(OpenAPI.umengAndroidPvEventParamGetValueList().get(0));
       // System.out.println(configService.umengAndroidPvEventParamGetValueList().get(0));

//        GoodsDataTimer goodsDataTimer=new GoodsDataTimer();
//        goodsDataTimer.timer3();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
    }
}
