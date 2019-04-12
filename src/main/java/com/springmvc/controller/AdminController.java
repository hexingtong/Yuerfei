package com.springmvc.controller;

import com.aliyuncs.utils.StringUtils;
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
@Api(value="登录类",tags={"登录退出接口"})
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
    @ApiIgnore()
    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session) {

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
    @ApiIgnore()
    @RequestMapping("/loginhoutai")
    @ResponseBody
    public JsonModel login(String userName, String pwd, HttpSession session) {

    logger.info("传入用户名+密码"+userName+pwd);
System.out.println("加密密码"+new Md5Hash("123", "123456", 5).toString());
    Subject subject = null;
        try {

          subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                //已经通过登录
                logger.info("已经登录");
                return new JsonModel(JsonModel.SUCCESS);
            }
            UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
            token.setRememberMe(true);
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
            return new JsonModel(JsonModel.FAILED, error);
        }
    logger.info("session=------------------"+session.getAttribute("user"));
    boolean isAuthenticated = subject.isAuthenticated();
    // 打印认证结果
    System.out.println("认证结果：" + isAuthenticated);
    return new JsonModel(JsonModel.SUCCESS);
    }

    @ApiOperation(value = "后台登录页面", httpMethod = "POST", response = StatusCode.class, notes = "后台登录页面")
    @RequestMapping("/login2")
    public void ogin2(String userName, String pwd, HttpSession session,HttpServletResponse response,HttpServletRequest request) {
    logger.info("进入控制器");
        ListObject listObject=new ListObject();
       if (StringUtils.isNotEmpty(userName)&&StringUtils.isNotEmpty(pwd)){

           kn_admin user = adminService.queryByPhone(userName);

           if(user.getLevel()==2){
               System.out.println("为商家id");
               String i="no";
               ResponseUtils.renderJson(response, JsonUtils.toJson(i));
               return;
           }
           if(user!=null&&user.getLevel()!=2){
               logger.info("传入密码"+pwd+"数据库密码"+user.getPwd());
               if (pwd.equals(user.getPwd())){
                   session.setAttribute("user",user);
                   kn_admin user2=new kn_admin();
                   user2.setId(user.getId());
                   user2.setLoginTime(new Date());
                   try {
                  String ip= IPutil.getIpAddress(request);
                  logger.info("得到的ip"+ip);
                       user2.setLoginIp(ip);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                      adminService.updateSelectiveById(user2);

                   System.out.println("suse");
                   String i="suse";
                   listObject.setCode(StatusCode.CODE_SUCCESS);
                   ResponseUtils.renderJson(response, JsonUtils.toJson(i));
               }else {
                   //密码不正确
                   String i="fail2";
                   System.out.println("fail2");
                   listObject.setCode(StatusCode.CODE_ERROR);
                   ResponseUtils.renderJson(response, JsonUtils.toJson(i));
               }
           }else {
               //查不到数据
               String i="fail";
               System.out.println("fail");
               listObject.setCode(StatusCode.CODE_ERROR);
               listObject.setMsg("查不到数据" );
               ResponseUtils.renderJson(response, JsonUtils.toJson(i));
           }
       }else {
           //传入值为空
           String i="null";
           System.out.println("null");
           listObject.setCode(StatusCode.CODE_ERROR);
           listObject.setMsg("null" );
           ResponseUtils.renderJson(response, JsonUtils.toJson(i));
       }
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
    @ApiIgnore()
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
 * @author boyang
 * @date 2019/3/16 16:13
 * @param
 * @return
 */
@ApiOperation(value = "退出登录", httpMethod = "POST", response = StatusCode.class, notes = "退出登录")
@RequestMapping("/loginOut")
public String deleSesson(Model model, HttpSession session, HttpServletRequest request) {

    if (session.getAttribute("user")!=null){
        request.getSession().removeAttribute("user");//清空session信息
        request.getSession().invalidate();//清除 session 中的所有信息
        return "login";
    }else {
        return "";
    }
}




}
