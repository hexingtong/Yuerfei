package com.springmvc.controller;


import com.springmvc.pojo.kn_admin;
import com.springmvc.service.kn_adminservice;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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






    @RequestMapping("/SMSPhone")
    @ResponseBody
    public void setSMSPhne(HttpServletResponse response,int code,HttpSession session){
        // Integer SmsCode=(Integer) session.getAttribute("code");
        int SmsCode=SmsPhone.getNewcode();
        List<kn_admin> lst=new ArrayList<kn_admin>();
        ListObject listObject=new ListObject();
//      if(SmsCode.equals(code)){
        if(SmsCode!=code){
            listObject.setItems(lst);
            listObject.setCode(StatusCode.CODE_ERROR);
            listObject.setMsg("验证码错误！");
            ResponseUtils.renderJson(response,JsonUtils.toJson(listObject));
        }
        else if(code==SmsCode) {
            listObject.setItems(lst);
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("验证码正确");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }

    }




}
