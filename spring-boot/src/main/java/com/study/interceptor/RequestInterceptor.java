package com.study.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author yk
 * @version 1.0 Date: 2017/6/7
 */
public class RequestInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("requestStartTime", startTime);
        HandlerMethod handlerMethod = (HandlerMethod) o;
        Method method = handlerMethod.getMethod();
        logger.info("用户IP: {}", this.getIp(request));
        logger.info("请求类方法: {}", method.getDeclaringClass().getName() + "." + method.getName());
        logger.info("请求URL: {}, 请求方式: {}", request.getRequestURL(), request.getMethod());
        logger.info("请求参数: [{}]", request.getQueryString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) o;
        Method method = handlerMethod.getMethod();
        long startTime = (Long) request.getAttribute("requestStartTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;

        if (executeTime > 1000) {
           logger.info("执行[" + method.getDeclaringClass().getName() + "." + method.getName() + "] 耗时 : "
                    + executeTime + "ms");
        } else {
            logger.info("执行[" + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "] 耗时 : "
                    + executeTime + "ms");
        }
    }

    /**
     * 获取Ip地址
     * @param request
     * @return
     */
    public  String getIp(HttpServletRequest request)  {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
