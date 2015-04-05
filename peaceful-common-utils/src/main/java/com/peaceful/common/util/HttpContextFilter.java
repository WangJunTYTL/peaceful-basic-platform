package com.peaceful.common.util;

import javax.servlet.*;
import java.io.IOException;

/**
 * Date 14/10/21.
 * Author WangJun
 * Email wangjuntytl@163.com
 * <p/>
 * 将servlet最常用的两个对象（request，response）放入到线程上下文，以便可以在任何地方拿到这两个对象
 */
public class HttpContextFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Http.setRequest((javax.servlet.http.HttpServletRequest) request);
        Http.setResponse((javax.servlet.http.HttpServletResponse) response);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
