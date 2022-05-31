package com.ob11to.http.servlet;

import com.ob11to.http.dto.UserDto;
import com.ob11to.http.service.UserService;
import com.ob11to.http.util.JspHelper;
import com.ob11to.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(UrlPath.LOGIN)
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login"))
                .forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var email = req.getParameter("email");
        var password = req.getParameter("password");

        userService.login(email,password)
                .ifPresentOrElse(
                        user -> onLoginSuccess(req, resp, user),
                        () -> onLoginFail(req,resp)
                );
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        resp.sendRedirect(UrlPath.LOGIN + "?error&email=" + req.getParameter("email"));
    }


    @SneakyThrows
    private void onLoginSuccess(HttpServletRequest req, HttpServletResponse resp, UserDto user){
        req.getSession().setAttribute("user", user);//получаем сессию и добавляем атрибуты
        resp.sendRedirect(UrlPath.FLIGHTS);
    }
}
