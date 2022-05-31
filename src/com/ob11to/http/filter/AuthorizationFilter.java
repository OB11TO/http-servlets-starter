package com.ob11to.http.filter;

import com.ob11to.http.dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

import static com.ob11to.http.util.UrlPath.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(LOGIN, REGISTRATION, IMAGES, LOCALE); //сделал публичные пути, которые доступны

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        var requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if(isPublicPath(requestURI) || isUserLoggedId(servletRequest)){ //проверка на публичный путь и на зарегистрированного пользователя
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            reject((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse); //отказ
        }
    }

    private void reject(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
        var prevPage = servletRequest.getHeader("referer"); //предыдущая страница
        servletResponse.sendRedirect(prevPage != null ? prevPage : LOGIN); //Возвращаемся на пред страницу иначе на логин
    }

    private boolean isUserLoggedId(ServletRequest servletRequest) {
        var user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String requestURI) {
        return PUBLIC_PATH.stream().anyMatch(requestURI::startsWith);
    }
}
