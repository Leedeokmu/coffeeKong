package com.coffeekong;

import com.coffeekong.interceptor.AuthInterceptor;
import com.coffeekong.interceptor.AuthMgrInterceptor;
import com.coffeekong.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Autowired
    AuthInterceptor authInterceptor;
    @Autowired
    AuthMgrInterceptor authMgrInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/order/**");
    }
}
