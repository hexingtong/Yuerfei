package com.springmvc.controller;

import com.springmvc.pojo.kn_friend;
import com.springmvc.service.FriendService;
import com.springmvc.service.FriendTimer;
import com.util.OpenAPI;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TimerController {

    @Autowired
    private com.springmvc.service.FriendService FriendService;
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 定时完成更新pvuv数据
     * @Date 13:32 2019/3/26
     * @Param []
     * @return void
     **/
    @Scheduled(cron="0 0 0 * * ?" )   //每10秒执行一次
    public void test(){
        System.out.println("-----------------进入定时器-----------------");
        String format="visitor";
        kn_friend kn_friend=new kn_friend();
        //kn_friend=FriendService.selectAlllAndFriend();
        List<kn_friend> lst=FriendService.queryAll();
        Map map=new HashMap();
        for(int i=0;i<lst.size();i++){
            kn_friend=lst.get(i);
            System.out.println(kn_friend.getId());
            System.out.println(kn_friend.getUrl());
            map=FriendTimer.Totalpvuv(kn_friend.getUrl(),format);
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
                System.out.println("对象里有没有id值"+kn_friend.getId());
                int folat=FriendService.updateFrilend(kn_friend);
                if(folat>0){
                    System.out.println("编辑成功");
                }else{
                    System.out.println("编辑失败");
                }
            }
            System.out.println("结束");
        }
        System.out.println("-----------------定时器结束-----------------");

    }

}
