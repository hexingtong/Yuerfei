package com.util.timeUtil;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Job1
 * @Description:
 * @Author by
 * @Date: 2019/3/25 15:59
 **/
public class FirstQuartzTest   {
    private int num=1;

    public void  test(){
        System.out.println("now time is:"+
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(num);
        num++;

    }


}