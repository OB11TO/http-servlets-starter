package com.ob11to.http.servlet;

import com.ob11to.http.util.UrlPath;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(UrlPath.FIRST)
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
        var paramValue = req.getParameter("param"); // принимаю параметр
        var parameterMap = req.getParameterMap(); // принимаю список параметров
        System.out.println();


        //RESPONSE
        resp.setContentType("text/html; charset=UTF-8"); //тип отправления клиенту | добавили русификацию
        resp.setHeader("token","123321"); // кастомный хедер
        //resp.setCharacterEncoding(StandardCharsets.UTF_8.name());  можно передавать, чтобы не было проблем с русификацией
        try (var writer = resp.getWriter()) { //поток вывода
            writer.write("<h1>ПРИВЕТ<h1/>"); //отправка
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var parameterMap = req.getParameterMap();
        var entrySet = parameterMap.entrySet();
        entrySet.forEach(System.out::println);
        System.out.println(parameterMap);

        try (var reader = req.getReader(); //поток считывания, чтобы считать запрос body
            var lines = reader.lines()){ //стрим строк из потока, который считали
            lines.forEach(System.out::println);
        }
    }

    @Override
    public void destroy() { // удалить сервлет из каталины
        super.destroy();
    }
}
