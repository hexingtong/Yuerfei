package com.springmvc.controller;

import com.aliyuncs.utils.StringUtils;
import com.springmvc.mapping.FriendAdminMapper;
import com.springmvc.pojo.FriendAdmin;
import com.springmvc.pojo.JsonModel;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.springmvc.service.kn_adminservice;
import com.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AdminController
 * @Description:登录类
 * @Author by
 * @Date: 2019/3/1 11:36
 **/
@Api(value = "登录类", tags = {"登录退出接口"})
@Controller
@RequestMapping("/admin2")
public class AdminController {
    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);
    @Autowired
    private kn_adminservice adminService;
    @Autowired
    private FriendAdminMapper friendAdminMapper;

    /**
     * 登录页面
     *
     * @return String
     * @Description: TODO
     * @author
     */
    @ApiIgnore()
    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session) {
        return "login";
    }

    /**
     * 登录
     *
     * @param userName
     * @param pwd
     * @return JsonModel
     * @Description: TODO
     * @author
     */
    @ApiIgnore()
    @RequestMapping("/loginhoutai")
    @ResponseBody
    public JsonResult login(String userName, String pwd, HttpSession session) {
        logger.info("传入用户名+密码" + userName + pwd);
        Subject subject = null;
        JsonResult jsonResult = new JsonResult();
        try {
            subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                //已经通过登录
                logger.info("已经登录");
                jsonResult.setCode(StatusCode.SUCCESSFULLY);
                return jsonResult;
            }
            UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
            token.setRememberMe(true);
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
            String error = "";
            if (e instanceof UnknownAccountException) {
                error = "The account does not exist";
                jsonResult.setMessage("The account does not exist");

            } else if (e instanceof IncorrectCredentialsException) {
                error = "Incorrect account or password";
                jsonResult.setMessage("Incorrect account or password");
            } else {
                error = "Unknown error, please contact administrator";
                jsonResult.setMessage("Unknown error, please contact administrator");
            }
            return jsonResult;
        }
        logger.info("session=------------------" + session.getAttribute("user"));
        boolean isAuthenticated = subject.isAuthenticated();
        // 打印认证结果
        System.out.println("认证结果：" + isAuthenticated);
        jsonResult.setMessage("登录成功");
        jsonResult.setCode(StatusCode.SUCCESSFULLY);
        return jsonResult;
    }

    @ApiOperation(value = "后台登录页面", httpMethod = "POST", response = StatusCode.class, notes = "后台登录页面")
    @RequestMapping("/login2")
    public void ogin2(String userName, String pwd, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        logger.info("userName" + userName + "pwd" + pwd);
        logger.info("进入控制器");
        ListObject listObject = new ListObject();
        if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(pwd)) {
            kn_admin user = adminService.queryByPhone(userName);
            if (user.getLevel() == 2) {
                System.out.println("为商家id");
                String i = "no";
                ResponseUtils.renderJson(response, JsonUtils.toJson(i));
                return;
            }
            if (user != null && user.getLevel() != 2) {
                logger.info("传入密码" + pwd + "数据库密码" + user.getPwd());
                if (pwd.equals(user.getPwd())) {
                    session.setAttribute("user", user);
                    kn_admin user2 = new kn_admin();
                    user2.setId(user.getId());
                    user2.setLoginTime(new Date());
                    try {
                        String ip = IPutil.getIpAddress(request);
                        logger.info("得到的ip" + ip);
                        user2.setLoginIp(ip);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    adminService.updateSelectiveById(user2);
                    System.out.println("suse");
                    String i = "suse";
                    listObject.setCode(StatusCode.CODE_SUCCESS);
                    ResponseUtils.renderJson(response, JsonUtils.toJson(i));
                } else {
                    //密码不正确
                    String i = "fail2";
                    System.out.println("fail2");
                    listObject.setCode(StatusCode.CODE_ERROR);
                    ResponseUtils.renderJson(response, JsonUtils.toJson(i));
                }
            } else {
                //查不到数据
                String i = "fail";
                System.out.println("fail");
                listObject.setCode(StatusCode.CODE_ERROR);
                listObject.setMsg("查不到数据");
                ResponseUtils.renderJson(response, JsonUtils.toJson(i));
            }
        } else {
            //传入值为空
            String i = "null";
            System.out.println("null");
            listObject.setCode(StatusCode.CODE_ERROR);
            listObject.setMsg("null");
            ResponseUtils.renderJson(response, JsonUtils.toJson(i));
        }
    }

    /**
     * Description：用于推送的时候登录
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/5/7 17:16
     */
    @ApiOperation(value = "推广登录页面", httpMethod = "POST", response = StatusCode.class, notes = "推广登录页面")
    @RequestMapping("/login3")
    @ResponseBody
    public JsonResult login3(String userName, String pwd, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(pwd)) {
            FriendAdmin friendAdmin = friendAdminMapper.getPwd(userName);
            if (friendAdmin != null) {
                logger.info("传入密码" + pwd + "数据库密码" + friendAdmin.getPwd());
                if (pwd.equals(friendAdmin.getPwd())) {
                    jsonResult.setMessage("登录成功");
                    jsonResult.setCode(StatusCode.SUCCESSFULLY);
                    jsonResult.setData(friendAdmin.getShorturl());
                    session.setAttribute("tuiName",friendAdmin);
                    return jsonResult;
                } else {
                    jsonResult.setMessage("密码错误");
                    jsonResult.setCode(StatusCode.FAILED);
                    return jsonResult;
                }
            } else {
                jsonResult.setMessage("账号不存在");
                jsonResult.setCode(StatusCode.FAILED);
                return jsonResult;
            }
        } else {
            jsonResult.setMessage("传入值为空");
            jsonResult.setCode(StatusCode.FAILED);
            return jsonResult;
        }
    }

    /**
     * 后台欢迎页
     *
     * @param model
     * @return String
     * @Description: TODO
     * @autho
     */
    @ApiIgnore()
    @RequestMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    /**
     * 首页
     *
     * @param model
     * @return String
     * @Description: TODO
     * @author
     */
    @ApiIgnore()
    @RequestMapping("/index")
    public String toIndex(Model model) {
        return "index";
    }

    @ApiIgnore()
    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(Model model) {
        return "admin/updatePassword";
    }

    /**
     * Description：退出登录清除sesion
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/16 16:13
     */
    @ApiOperation(value = "退出登录", httpMethod = "POST", response = StatusCode.class, notes = "退出登录")
    @RequestMapping("/loginOut")
    @ResponseBody
    public Integer deleSesson(Model model, HttpSession session, HttpServletRequest request) {
        logger.info(String.valueOf(session.getAttribute("user")));
        if (session.getAttribute("user") != null) {
            request.getSession().removeAttribute("user");//清空session信息
            request.getSession().invalidate();//清除 session 中的所有信息
            return 1;
        } else {
            return 0;
        }
    }
}
