package com.springmvc.controller;

import com.springmvc.pojo.kn_friend;
import com.springmvc.service.FriendService;
import com.springmvc.service.FriendTimer;
import com.util.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/TimerFride")
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
    @RequestMapping("/friend")
    @ResponseBody
    public void TimerFriend(HttpServletResponse response){
        ListObject listObject=new ListObject();
        System.out.println("拿取数据");
        String format="visitor";
        kn_friend kn_friend=new kn_friend();
        //kn_friend=FriendService.selectAlllAndFriend();
        List<kn_friend> lst=FriendService.selectFriendAll();
        Map map=new HashMap();
        for(int i=0;i<lst.size();i++){
            kn_friend=lst.get(i);
            System.out.println("查询的id"+kn_friend.getId());
            System.out.println("查询的url"+kn_friend.getUrl());
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
                    listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                    listObject.setMsg("编辑失败");
                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                }
            }else{
                listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                listObject.setMsg("上传链接失败");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }
        listObject.setCode(StatusCode.CODE_SUCCESS);
        listObject.setMsg("编辑成功");
        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        System.out.println("-----------------拿取结束-----------------");

    }

}
