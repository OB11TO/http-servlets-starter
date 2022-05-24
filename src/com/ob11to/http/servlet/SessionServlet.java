package com.ob11to.http.servlet;

import com.ob11to.http.dto.UserDto;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        var session = req.getSession(); //получить сессию
        //System.out.println(session.isNew());
        var attributeUser = (UserDto) session.getAttribute(USER); // получить атрибут
        if(attributeUser == null){  //если атрибута нет, создать
            attributeUser = UserDto.builder()
                    .id(25L)
                    .mail("test@gmail.com")
                    .build();
            session.setAttribute("user", attributeUser); //
        }
    }
}
