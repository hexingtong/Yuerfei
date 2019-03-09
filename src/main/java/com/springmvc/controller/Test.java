package com.springmvc.controller;

import com.util.DateUtil;
import com.util.DateUtils2;
import com.util.TokenTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


public class Test {

    public static String isClient(HttpServletRequest request){
        String userAgent = request.getHeader("user-agent").toLowerCase();
        if (userAgent == null || userAgent.indexOf("windows nt") == -1 ? false : true) { // 判断当前客户端是否为PC
            return "pc";
        } else if (userAgent == null || userAgent.indexOf("android") == -1 ? false : true) { // 判断当前客户端是否为android
            return "android";
        } else if (userAgent == null || userAgent.indexOf("iphone") == -1 ? false : true) { // 判断当前客户端是否为iPhone
            return "iPhone";
        } else if (userAgent == null || userAgent.indexOf("wap") == -1 ? false : true) { // 判断当前客户端是否为wap
            return "wap";
        } else if (userAgent == null || userAgent.indexOf("micromessenger") == -1 ? false : true) { // 判断当前客户端是否为微信
            return "weixin";
        }
        return "";
    }



    public static void main(String[] args) {

//        String utilDates=DateUtil.getNowDate();
//        Date date=DateUtil.stringToDate(utilDates);
//        System.out.println("获取的Date时间"+DateUtil.getNowDate());
//        System.out.println("yyyyMMddHHmmss");
//        System.out.println("Date转换后的时间"+date);

//        Jedis jedis =new Jedis("47.92.53.177",6379);
//         String id="12";
//        String token = TokenTest.TokenTest(id);

////        TokenTest.ValidToken(token);
//
//        jedis.set("token"+id+"",token);
//
//        jedis.get("token"+id+"");
//        jedis.pexpire("token",30000);
        //String ken=jedis.get("token"+id,);
//        System.out.println("ken的值是:"+ken);
//        if(ken==null||ken.equals("")){
//            System.out.printf(ken);
//        }
//        System.out.printf("null");
//
//

//                String id="13";
//                String token = TokenTest.TokenTest(id);
//                TokenTest.ValidToken(token);

        DateUtils2.getNow();



    }


}
