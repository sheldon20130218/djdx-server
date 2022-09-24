package com.taoism.discipline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.taoism.discipline.Interceptor.LoginHandlerInterceptor;


@Configuration
public class DisciplineHandlerInterceptorConfig implements WebMvcConfigurer {
	
    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/register/**");
    }
}

