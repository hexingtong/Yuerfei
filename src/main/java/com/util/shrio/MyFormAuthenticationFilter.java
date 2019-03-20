package com.util.shrio;

import com.springmvc.pojo.ActiveUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName MyFormAuthenticationFilter
 * @Description: shrio设置登录成功页面跳转类
 * @Author by
 * @Date: 2019/3/15 9:35
 **/
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    final Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    private final String successUrl = "/admin2/index";
    //成功跳转类
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        logger.info("登录成功后进入---------");
        // /获取已登录的用户信息
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        //获取session
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpSession session = httpServletRequest.getSession();
        //把用户信息保存到session

        WebUtils.getAndClearSavedRequest(request);
        WebUtils.issueRedirect(request, response, successUrl, null, true);
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        logger.info("登录失败-------");

        try {
            issueSuccessRedirect(request,response);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return  false;
    }

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.issueRedirect(request, response, successUrl, null, true);
    }
}
