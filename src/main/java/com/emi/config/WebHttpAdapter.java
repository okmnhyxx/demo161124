package com.emi.config;

import com.emi.common.util.IpUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by emi on 2016/11/15.
 */
@Configuration
public class WebHttpAdapter extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public WebHttpAdapter() {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns(new String[]{"/**"});
//        registry.addInterceptor(new RequestInterceptor()).excludePathPatterns();
        super.addInterceptors(registry);
    }

    class RequestInterceptor extends HandlerInterceptorAdapter {

        public RequestInterceptor() {
        }

        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String agent = request.getHeader("User-Agent");
            Enumeration parameterNames = request.getParameterNames();
            StringBuilder sb = new StringBuilder();

            String params;
            while(parameterNames.hasMoreElements()) {
                params = (String)parameterNames.nextElement();
                String[] values = request.getParameterValues(params);
                sb.append("[").append(params).append(":").append(ArrayUtils.toString(values)).append("]");
            }

            params = StringUtils.isNotEmpty(sb.toString())?sb.insert(0, "\n").toString():"";
            logger.info("[{}] =>[{}] [{}] [{}]{}", new Object[]{IpUtils.getIpAddress(request), request.getMethod(), request.getRequestURL(), agent, params});
            request.setAttribute("_START_TIME", Long.valueOf(System.currentTimeMillis()));
            return super.preHandle(request, response, handler);
        }

        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            super.afterCompletion(request, response, handler, ex);
            long start = Long.parseLong(request.getAttribute("_START_TIME").toString());
            logger.info("[{}] =>[{}] [{}] cost[{}]ms", new Object[]{IpUtils.getIpAddress(request), request.getMethod(), request.getRequestURL(), Long.valueOf(System.currentTimeMillis() - start)});
        }
    }
}
