package com.springmvc.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.kn_adminservice;
import com.sun.javafx.collections.MappingChange;
import com.util.*;
import com.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.util.SmsPhone.sendSms;

@Controller
@RequestMapping("/admin")
public class kn_admintestController {
    @Autowired
    private kn_adminservice knAdminservice;



    /**
     * by  登录获取验证码
     * @param
     * @param response
     */
//    @RequestMapping("/getCode")
//    @ResponseBody
//    public void getList(Integer phone, HttpServletResponse response,HttpSession session){
//        System.out.print("传入手机号"+phone);
//        ListObject listObject =new ListObject();
//
//        if(!phone.equals("")||phone!=null){
//            //判断是否被注册
//            kn_admin knAdmin =new kn_admin();
//            if(knAdminservice.getPhone(phone)!=null||!knAdminservice.getPhone(phone).equals("")){
//                //被注册
//                System.out.print("传入手机号"+phone);
//                //发送短信调用借口
//                knAdmin=knAdminservice.getPhone(phone);
//                listObject.setMsg("发送成功");
//                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
//                int SmsCode = (int)((Math.random()*9+1)*100000);
//                session.setAttribute("code",SmsCode);
//                session.setAttribute("admin",knAdmin);
//
//            }else {
//                //没有注册
//                knAdmin.setAccount(phone);
//                Date date =new Date();
//                knAdmin.setAdd_time(date);
//                knAdminservice.updateSelectiveById(knAdmin);
//                //增加数据
//                System.out.print("数据被增加");
//                int SmsCode = (int)((Math.random()*9+1)*100000);
//                session.setAttribute("code",SmsCode);
//
//            }
//
//
//
//        }else {
//
//
//        }
//
//    }
//





    //发送验证码接口
    @RequestMapping("/SMSPhone")
    @ResponseBody
    public void setSMSPhne(HttpServletResponse response,int code,HttpSession session){
        // Integer SmsCode=(Integer) session.getAttribute("code");
        int SmsCode=SmsPhone.getNewcode();

    }
    //发送验证码接口
    @RequestMapping("/smsPhone")
    @ResponseBody
    public void test(HttpServletResponse response,String Phone,HttpSession session){

        try {
        SmsPhone.setNewcode();

        String code = Integer.toString(SmsPhone.getNewcode());
        SendSmsResponse sendSms=sendSms(Phone,code);
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + sendSms.getCode());
        System.out.println("Message=" + sendSms.getMessage());
        System.out.println("RequestId=" + sendSms.getRequestId());
        System.out.println("BizId=" + sendSms.getBizId());
        System.out.println("验证码为:"+code);
        if(sendSms.getCode().equals("OK")) {
            System.out.printf("成功");

            session.setAttribute("SmsCode",code);
            ListObject listObject = new ListObject();
            listObject.setItems(knAdminservice.queryAll());
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("发送成功！");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else{
            System.out.printf("失败");
            ListObject listObject = new ListObject();
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            listObject.setMsg("发送失败！");
        }

        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public void login(HttpSession session,HttpServletResponse response,String PhoneCode,String Phone){
//         String code=(String)session.getAttribute("SmsCode");
        String code="123";
        Jedis jedis =new Jedis("47.92.53.177",6379);
        ListObject listObject = new ListObject();
        List<kn_admin> lst = new ArrayList();
        kn_admin kn=new kn_admin();
        Map map=new HashMap();
        //判断验证码是否一致
        if(code.equals(PhoneCode)) {
            //判断是否注册
            if(knAdminservice.countAndmin(Phone)>0){
            //已经注册
                kn_admin kns=knAdminservice.queryByid(Phone);
                kn=knAdminservice.queryByid(Phone);
                System.out.println("已注册:" + Phone);
                System.out.println("测试数据");
                listObject.setItems(knAdminservice.queryListPhone(Phone));
                session.setAttribute("id",kns.getId());
                Object ids= session.getAttribute("id");
                String id=ids.toString();
                String token = TokenTest.TokenTest(id);
                //token 解析方法
                //TokenTest.ValidToken(token);
                listObject.setMsg("登录成功！");
                listObject.setCode(StatusCode.CODE_SUCCESS);
                map.put("listObject",listObject);
                map.put("token",token);
                //存入token
                jedis.set("token"+id+"",token);
                //设置时间为毫秒
                jedis.pexpire("token",1296000000);
                ResponseUtils.renderJson(response, JsonUtils.toJson(map));
            }else{
                //没有注册
                System.out.println("未注册:");
                kn.setPhone(Phone);
                String dateUtil=DateUtil.getNowDate();
                Date utilDate=DateUtil.stringToDate(dateUtil);
                kn.setAdd_time(utilDate);
                kn.setLogin_time(utilDate);
                System.out.println("Date时间:"+kn.getAdd_time());
               if(knAdminservice.insertAndmin(kn)>0){
                    System.out.println("注册成功！");
                    //根据手机号查询id
                    kn_admin kns=knAdminservice.queryByid(Phone);
                    session.setAttribute("id",kns.getId());
                    System.out.println("测试id值"+session.getAttribute("id"));
                    Object ids= session.getAttribute("id");
                    String id=ids.toString();
                    System.out.println();
                    String token = TokenTest.TokenTest(id);
                    TokenTest.ValidToken(token);
                    listObject.setMsg("注册成功&&通过验证");
                    listObject.setCode(StatusCode.CODE_SUCCESS);
                    System.out.println("id数据:"+id);
                    listObject.setItems(knAdminservice.queryListPhone(Phone));
                    map.put("listObject",listObject);
                    map.put("token",token);
                   //存入token
                   jedis.set("token"+id+"",token);
                   //设置时间为毫秒
                   jedis.pexpire("token",1296000000);

                    ResponseUtils.renderJson(response,JsonUtils.toJson(map));

               }else{
                   System.out.println("注册失败！");
                   listObject.setMsg("注册失败！");
                   listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                   listObject.setItems(lst);
                   ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
               }
            }

        }else{
              listObject.setItems(lst);
              listObject.setMsg("验证码不正确！");
              listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
              listObject.setItems(lst);
              ResponseUtils.renderJson(response,JsonUtils.toJson(listObject));
        }




    }


    public static void main(String[] args) {
        Jedis jedis =new Jedis("172.26.62.118",6379);
        jedis.set("name","俊杰");
        System.out.printf(jedis.get("name"));
    }


}
