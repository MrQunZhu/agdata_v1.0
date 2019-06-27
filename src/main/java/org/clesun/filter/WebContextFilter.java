package org.clesun.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by clesun on 2016/10/25.
 */
public class WebContextFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置跨域问题
        String origin = servletRequest.getRemoteHost() +":"+servletRequest.getRemotePort();

        System.out.print("走了过滤器"+origin);

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,OPTIONS,DELETE");
//        x-requested-with,
        response.setHeader("Access-Control-Allow-Headers","AuthenticationOrigin,Content-Type,X-Requested-With,Accept");
        response.setHeader("Access-Control-Allow-Credentials","true");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
