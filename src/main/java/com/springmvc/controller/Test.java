package com.springmvc.controller;

import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Test {





    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);
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
//        Map map=new HashMap();
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI0MyIsInN0YSI6MTU1MjM3NDQzODU0NSwiZXhwIjoxNTUzNjcwNDM4NTQ1fQ.DtwhMMxsGaMshwiQ8IyrUTPKPJJHtI0P9KCwAT1FHD8";
//        TokenTest.ValidToken(token);
//        Jedis jedis = new Jedis("47.92.53.177", 6379);
//        SmsPhone.setNewcode();
//        String code=Integer.toString(SmsPhone.getNewcode());
//        System.out.println("验证码:"+code);
//        String Phone="13022061303";
//        jedis.set("SmsCode" + Phone + "", code);
////        //设置时间为毫秒
//        jedis.pexpire("SmsCode" + Phone + "", 60000);
//        String z="SmsCode"+Phone;
//        String x=jedis.get(z);
//        logger.info("z里面的值:"+z);
//        logger.info("redis里的验证码为："+x);


    }


}
