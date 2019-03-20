package com.springmvc.controller;

import com.springmvc.pojo.KnFriend;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName shrioTest
 * @Description:
 * @Author by
 * @Date: 2019/3/4 17:24
 **/
@Controller
@RequestMapping("/shrio")
public class shrioTest {

   @RequestMapping("/sh")
    public  String login( String phone,String password){
        phone="12345";
        password="123";
        //密码要
        Subject subject = SecurityUtils.getSubject();
        // 创建Token，这个token就是用户输入的用户名和密码做成的token令牌，将来要从数据库中获取
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
        // 认证提交，认证不通过时会报异常
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
// 认证结果：认证通过放回true，失败返回false
        boolean isAuthenticated = subject.isAuthenticated();
        // 打印认证结果
        System.out.println("认证结果：" + isAuthenticated);
       return "index";

    }

    @RequestMapping("/test")
    @ResponseBody
    public KnFriend getTest(){

       return null;

    }






}
