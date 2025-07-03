//package com.neusoft.SP01.interceptor;
//
//import com.alibaba.fastjson.JSONObject;
//import com.neusoft.SP01.util.JwtUtils;
//import com.neusoft.SP01.po.ResponseBean;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * 拦截器
// */
//@Slf4j
//@Component//用于拦截器的注册
//public class LoginCheckInterceptor implements HandlerInterceptor {
//
//    //目标资源（Controller）运行前运行
//    @Override
//    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
//        //可以仿照过滤器的逻辑来写这部分方法的实现
//        //1.获取请求的url
//        String url = req.getRequestURL().toString();
//        log.info("请求的url {}", url);
//        //2.请求的url包含login->放行
//        if (url.contains("login")) {
//            log.info("登录放行");
//            return true;//true是放行
//        }
//        //3.获取请求头中的令牌（token）
//        String jwt = req.getHeader("token");
//        //4.判断令牌是否存在，不存在返回错误信息
//        if (!StringUtils.hasLength(jwt)) {//令牌不存在
//            log.info("令牌为空，返回登录的信息");
//            ResponseBean<Object> notLogin1 = new ResponseBean<>(500, "NOT_LOGIN");
//            //手动将对象转为JSON格式（Controller层是因为有@ResController注解能够自动将对象转为JSON格式了无需手动）
//            String notLogin = JSONObject.toJSONString(notLogin1);
//            resp.getWriter().write(notLogin);
//            return false;//false是不放行
//
//            /*
//            实训老师教的
//            PrintWriter p = resp.getWriter();
//            p.write("notLogin");
//            p.close();
//             */
//        }
//        //5.解析token，失败的话返回错误信息
//        /*
//        实训老师课上内容
//        从令牌中截取userId
//        根据userId从redis获取对应的值，然后于jwt比较是否相等 不相等false,否则true
//         */
//        try {
//            JwtUtils.parseToken(jwt);
//        } catch (Exception e) {//解析失败
//            e.printStackTrace();
//            log.info("解析令牌失败，返回错误信息");
//            ResponseBean<Object> notLogin1 = new ResponseBean<>(500, "NOT_LOGIN");
//            //手动将对象转为JSON格式（Controller层是因为有@ResController注解能够自动将对象转为JSON格式了无需手动）
//            String notLogin = JSONObject.toJSONString(notLogin1);
//            resp.getWriter().write(notLogin);
//            return false;
//        }
//        //放行
//        log.info("解析成功，放行");
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//}
