package com.springmvc.controller;

import com.springmvc.pojo.JsonModel;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.springmvc.service.kn_adminservice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AdminController
 * @Description:登录类
 * @Author by
 * @Date: 2019/3/1 11:36
 **/
@Controller
@RequestMapping("/admin2")
public class AdminController {
    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);

    @Autowired
    private kn_adminservice adminService;

    /**
     * 登录页面
     *
     * @Description: TODO
     * @author
     * @return
     * @return String
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录
     *
     * @Description: TODO
     * @author
     * @param userName
     * @param pwd
     * @return
     * @return JsonModel
     */
@RequestMapping("/loginhoutai")
    public String login(String userName, String pwd) {
    logger.info("传入用户名+密码"+userName+pwd);
    Subject subject = null;
        try {
          subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
            subject.login(token);

        } catch (Exception e) {
            e.printStackTrace();
            String error = "";
            if (e instanceof UnknownAccountException) {
                error = "The account does not exist";
            } else if (e instanceof IncorrectCredentialsException) {
                error = "Incorrect account or password";
            } else {
                error = "Unknown error, please contact administrator";
            }


        }
    boolean isAuthenticated = subject.isAuthenticated();
    // 打印认证结果
    System.out.println("认证结果：" + isAuthenticated);
        return "/admin2/index";
    }

    /**
     * 后台欢迎页
     *
     * @Description: TODO
     * @autho
     * @param model
     * @return
     * @return String
     */
    @RequestMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    /**
     * 首页
     *
     * @Description: TODO
     * @author
     * @param model
     * @return
     * @return String
     */
    @RequestMapping("/index")
    public String toIndex(Model model) {
        return "index";
    }

    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(Model model) {
        return "admin/updatePassword";
    }

  /*  @RequestMapping("/savePassword")
    @ResponseBody
    public int savePassword(Model model, String oldPassword, String newPassword) {
        Subject subject = SecurityUtils.getSubject();
        int userId = 0;
        if (subject != null) {
            ActiveUser shiroUser = (ActiveUser) subject.getSession().getAttribute("activeUser");
            if (shiroUser != null) {
                userId = shiroUser.getId();
            }
        }
        Admin admin = adminService.queryById(userId);
        if (admin == null) {
            return 0;// 用户不存在
        }
        if (!oldPassword.equals(admin.getPassword())) {
            return -1;// 原始密码错误
        }
        admin.setPassword(newPassword);
        adminService.updateSelectiveById(admin);
        return 1;
    }*/

}
