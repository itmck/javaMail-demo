package com.qf.manager.web;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Create by it_mck 2018/10/16 13:38
 *
 * @Description: 登录拦截器 session过滤
 * @Version: 1.0
 */
public class LoginFilterController implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {


        //
        //设置登录过滤器,获取session域.然后获取登录名
        HttpSession session = httpServletRequest.getSession();
        if (null == session.getAttribute("login_user")) {//登录名不存在存在,跳转至登录页面
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/log/indexLogin");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
