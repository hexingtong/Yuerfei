package com.util;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @ClassName LoginHandlerInterceptor
 * @Description: 登录拦截器
 * @Author by
 * @Date: 2019/3/20 11:07
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("进入拦截器");
        //System.out.println(request.getSession().getAttribute("user"));
//        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("user");
//        System.out.println("user"+request.getSession().getAttribute("user"));
        if (request.getSession().getAttribute("user")==null ) {
            System.out.println("null/admin2/toLogin");
//            response.sendRedirect("/index.jsp");
           response.setStatus(401);
            return false;
        }else {
            System.out.println("true");
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("user"+httpServletRequest.getSession().getAttribute("user"));
        this.preHandle(httpServletRequest,httpServletResponse,o);

    }
}
