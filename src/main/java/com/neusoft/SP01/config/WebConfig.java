//package com.neusoft.SP01.config;
//
//import com.neusoft.SP01.interceptor.LoginCheckInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.ArrayList;
//
//@Configuration//配置类注解
//public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    private LoginCheckInterceptor interceptor;
//    public void addInterceptors(InterceptorRegistry registry) {
//        ArrayList<String> path = new ArrayList<>();
//        path.add("/UserController/login");//登录请求不拦截
//        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(path);
//    }
//}
