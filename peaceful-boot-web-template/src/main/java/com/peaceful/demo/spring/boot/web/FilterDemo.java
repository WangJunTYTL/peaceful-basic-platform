package com.peaceful.demo.spring.boot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangjun on 16/7/24.
 */
@WebFilter(filterName = "my_filter", urlPatterns = "/**")
public class FilterDemo implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("my filter complete init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.info("request url->{}",request.getRequestURI());
        HttpServletResponse response = (HttpServletResponse) servletResponse;
    }

    @Override
    public void destroy() {

    }
}
