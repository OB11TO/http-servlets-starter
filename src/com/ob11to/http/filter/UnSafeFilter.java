package com.ob11to.http.filter;

import com.ob11to.http.dto.UserDto;
import com.ob11to.http.util.UrlPath;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter("/admin")
public class UnSafeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        if(user != null){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect(UrlPath.REGISTRATION);
        }

    }
}
