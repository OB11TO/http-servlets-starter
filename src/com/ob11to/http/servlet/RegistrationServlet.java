package com.ob11to.http.servlet;

import com.ob11to.http.dto.CreateUserDto;
import com.ob11to.http.entity.Gender;
import com.ob11to.http.entity.Role;
import com.ob11to.http.exception.ValidatorException;
import com.ob11to.http.service.UserService;
import com.ob11to.http.util.JspHelper;
import com.ob11to.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 *1024)
@WebServlet(value = UrlPath.REGISTRATION, name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());
        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var name = req.getParameter("name");
        var image = req.getPart("image");

        var userDto = CreateUserDto.builder()
                .name(req.getParameter("username"))
                .image(req.getPart("image"))
                .birthday(req.getParameter("birthday"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .build();

        try {
            userService.create(userDto);
            resp.sendRedirect(UrlPath.LOGIN);
        }catch (ValidatorException exception){
            req.setAttribute("errors",exception.getErrors());
            doGet(req,resp);
        }

    }
}
