package com.util.Timer;

import com.util.OpenAPI;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


public class TimerTask {

    @Scheduled(cron = "0/2 * * * * ?")//每隔2秒隔行一次

    public void test2()
    {
        System.out.println("job1 开始执行");

    }

}
