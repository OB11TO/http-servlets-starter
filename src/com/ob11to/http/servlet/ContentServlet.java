package com.ob11to.http.servlet;

import com.ob11to.http.dto.FlightDto;
import com.ob11to.http.service.FlightService;
import com.ob11to.http.util.JspHelper;
import com.ob11to.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(UrlPath.CONTENT)
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var flightDtos = flightService.findAll(); //получаем список всех перелетов dto
        req.setAttribute("flights", flightDtos); //задаем атрибуты (requestScope)
        //задаем атрибуты (sessionScope)
        req.getSession().setAttribute("flightsMap", flightDtos.stream().
                collect(Collectors.toMap(FlightDto::getId,FlightDto::getDescription)));

        //перенаправляем запрос в jsp
        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req,resp);
    }
}
