package com.ob11to.http.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/")
public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException { //глобальная переменая
        super.init(config);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //REQUEST
       req.getHeaders("user-agent"); // откуда пришел запрос
        var headerNames = req.getHeaderNames(); //итератор всех имен хедеров
        while (headerNames.hasMoreElements()){
            var header = headerNames.nextElement();
            System.out.println(header);
            System.out.println(req.getHeader(header));
            System.out.println();
        }
        //RESPONSE
        resp.setContentType("text/html; charset=UTF-8"); //тип отправления клиенту | добавили русификацию
        resp.setHeader("token","123321"); // кастомный хедер
        //resp.setCharacterEncoding(StandardCharsets.UTF_8.name());  можно передавать, чтобы не было проблем с русификацией
        try (var writer = resp.getWriter()) { //поток вывода
            writer.write("<h1>ПРИВЕТ<h1/>"); //отправка
        }
    }

    @Override
    public void destroy() { // удалить сервлет из каталины
        super.destroy();
    }
}
