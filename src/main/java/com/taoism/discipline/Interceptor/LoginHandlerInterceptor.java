package com.taoism.discipline.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.taoism.discipline.utils.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("访问controller之前调用");
        String[] array = request.getRequestURL().toString().split("/");
        String token = array[array.length-1];
        //如果没有Token，则不能验证通过
        if(null == TokenUtil.getOpenid(token)) {
        	return false;
        }
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("ModelAndView渲染前调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("完成请求和响应后调用");
    }
}


