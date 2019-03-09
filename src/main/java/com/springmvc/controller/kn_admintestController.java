package com.springmvc.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.MemberService;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.springmvc.service.kn_adminservice;
import com.sun.javafx.collections.MappingChange;
import com.util.*;
import com.util.token.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
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


    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);


    //发送验证码接口
    @RequestMapping(value = "/smsPhone")
    @ResponseBody
    public void test(HttpServletResponse response, String Phone, HttpSession session) {
        List<kn_admin> lst = new ArrayList();
        try {
        SmsPhone.setNewcode();

            String code = Integer.toString(SmsPhone.getNewcode());
            SendSmsResponse sendSms = sendSms(Phone, code);
            logger.info("短信接口返回的数据----------------");
            logger.info("Code=" + sendSms.getCode());
            logger.info("Message=" + sendSms.getMessage());
            logger.info("RequestId=" + sendSms.getRequestId());
            logger.info("BizId=" + sendSms.getBizId());
            logger.info("验证码为:" + code);
            if (sendSms.getCode().equals("OK")) {
                logger.info("成功");
                session.setAttribute("SmsCode", code);
                session.setAttribute("Smsphones", Phone);
                ListObject listObject = new ListObject();
                kn_admin kns = knAdminservice.queryByid(Phone);
                lst.add(kns);
                listObject.setItems(lst);
                listObject.setCode(StatusCode.CODE_SUCCESS);
                listObject.setMsg("发送成功！");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            } else {
                logger.info("失败");
                ListObject listObject = new ListObject();
                listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                listObject.setMsg(sendSms.getMessage());
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }

        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public void login(HttpSession session, HttpServletResponse response, String PhoneCode, String Phone, HttpServletRequest request) {
        ListObject listObject = new ListObject();
        List<kn_admin> lst = new ArrayList();

        String code = session.getAttribute("SmsCode").toString();
        String Phones = session.getAttribute("Smsphones").toString();
        System.out.println("code" + code + "phone" + Phones);

        logger.info(Phones);
        if (!code.equals("")&&code != null&&Phones.equals(Phone)&&Phones != null) {
            logger.info("------------------获取session的code 为：" + code);
            Jedis jedis = new Jedis("47.92.53.177", 6379);
            kn_admin kn = new kn_admin();
            Map map = new HashMap();
            //判断验证码是否一致
            if (code.equals(PhoneCode)) {
                //判断是否注册
                int i=knAdminservice.countAndmin(Phone);
                if (i>0) {
                    //已经注册
                    kn_admin kns = knAdminservice.queryByid(Phone);
                    List lsx = new ArrayList();
//                kn=knAdminservice.queryByid(Phone);
                    logger.info("已注册:" + Phone);
                    logger.info("测试数据");
                    kn_admin knAdmin2 = new kn_admin();
                    knAdmin2.setPhone(Phone);
                    session.setAttribute("id", kns.getId());
                    Object ids = session.getAttribute("id");
                    String id = ids.toString();
                    String token = TokenTest.TokenTest(id);
                    //token 解析方法
                    //TokenTest.ValidToken(token);
                    //date日期转换
                    String dateUtil = DateUtil.getNowDate();
                    Date utilDate = DateUtil.stringToDate(dateUtil);
                    //修改最后一次登录时间
                    kn_admin kna = new kn_admin();
                    kna.setLoginTime(utilDate);
                    kna.setId(Integer.parseInt(id));
                    //logger.info(""+knAdminservice.queryListPhone(Phone));

                    kn_admin knx = new kn_admin();
                    knAdmin2.setToken(token);
                    lsx = knAdminservice.queryListByWhere(knAdmin2);
                    ListObjectSuper listObjectSuper = new ListObjectSuper();
                    /* map.put("lis",kn);
                    map.put("token",token);*/
                    listObjectSuper.setMsg("登录成功！");
                    listObjectSuper.setCode(StatusCode.CODE_SUCCESS);
                    listObjectSuper.setItems(lsx);
                    listObjectSuper.setToken(token);
                    //存入token
                    jedis.set("token" + id + "", token);
                    //设置时间为毫秒
                    jedis.pexpire("token", 1296000000);
                    logger.info("登录成功：已注册用户");
                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObjectSuper));
                } else {
                    //没有注册
                    logger.info("未注册:");
                    kn.setPhone(Phone);
                    String dateUtil = DateUtil.getNowDate();
                    Date utilDate = DateUtil.stringToDate(dateUtil);
                    kn.setAddTime(utilDate);
                    kn.setLoginTime(utilDate);
                    String bs = Test.isClient(request);
                    //添加注册来源
                    //kn.setregistered_source();

                    logger.info("Date时间:" );
                    if (knAdminservice.insertAndmin(kn) > 0) {
                        logger.info("注册成功！");
                        //根据手机号查询id
                        kn_admin kns = knAdminservice.queryByid(Phone);
                        session.setAttribute("id", kns.getId());
                        logger.info("测试id值" + session.getAttribute("id"));
                        Object ids = session.getAttribute("id");
                        String id = ids.toString();
                        System.out.println();
                        String token = TokenTest.TokenTest(id);
                        TokenTest.ValidToken(token);
                        listObject.setMsg("注册成功&&通过验证");
                        listObject.setCode(StatusCode.CODE_SUCCESS);
                        logger.info("id数据:" + id);
                        kn_admin knAdmin2 = new kn_admin();
                        knAdmin2.setPhone(Phone);
                        lst = knAdminservice.queryListByWhere(knAdmin2);
                        ListObjectSuper listObjectSuper = new ListObjectSuper();
                        listObjectSuper.setItems(knAdminservice.queryListPhone(Phone));
                        listObjectSuper.setItems(lst);
                        listObjectSuper.setToken(token);
                        //存入token
                        jedis.set("token" + id + "", token);
                        //设置时间为毫秒
                        jedis.pexpire("token", 1296000000);
                        logger.info("注册登录成功:未注册用户");
                        ResponseUtils.renderJson(response, JsonUtils.toJson(listObjectSuper));
                    } else {
                        logger.info("注册失败！");
                        listObject.setMsg("注册失败！");
                        listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                        listObject.setItems(lst);
                        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                    }
                }

            } else {
                listObject.setItems(lst);
                listObject.setMsg("验证码不正确或手机号不正确");
                listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                listObject.setItems(lst);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }

        } else {

            listObject.setCode(StatusCode.CODE_ERROR);
            listObject.setMsg("没有获取到验证码或手机号");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }


    }


}
