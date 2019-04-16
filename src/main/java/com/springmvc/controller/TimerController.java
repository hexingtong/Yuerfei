package com.springmvc.controller;

import com.springmvc.mapping.kn_goodsMapper;
import com.springmvc.pojo.kn_friend;
import com.springmvc.pojo.kn_goods;
import com.springmvc.service.FriendService;
import com.springmvc.service.FriendTimer;
import com.springmvc.service.kn_goodsservice;
import com.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(value="推广页面数据刷新controller",tags={"推广操作接口"})
@Controller
@RequestMapping("/TimerFride")
public class TimerController {

    @Autowired
    private com.springmvc.service.FriendService FriendService;
    @Autowired
    private kn_goodsservice knGoodsservice;
    @Autowired
    private kn_goodsMapper knGoodsMapper;
    /**
     * @Author 苏俊杰
     * @Description //TODO 定时完成更新pvuv数据
     * @Date 13:32 2019/3/26
     * @Param []
     * @return void
     **/
    @ApiOperation(value = "更新推广页面链接的数据（pv uv）", httpMethod = "POST", response = StatusCode.class, notes = "更新推广页面链接的数据（pv uv）")
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
    /**
     * Description： 定时更新产品总的pvuv
     * @author boyang
     * @date 2019/4/13 15:34
     * @param 
     * @return 
     */
    @ApiOperation(value = "定时更新产品总的pvuv", httpMethod = "POST", response = StatusCode.class, notes = "定时更新产品总的pvuv")
    @Scheduled(cron= "0 0/6 * * * ? ")
    @RequestMapping("/uvpvx")
    public void unpvuvx(){
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
            map=FriendTimer.Totalpvuv(kn_friend.getShortUrl(),format);
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
