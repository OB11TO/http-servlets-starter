package com.ob11to.http.servlet;

import com.ob11to.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(UrlPath.DISPATCHER)
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/flight")
//                .forward(req,resp);
//
//
//        req.getRequestDispatcher("/flight")
//                .include(req,resp);

        resp.sendRedirect(UrlPath.FLIGHTS);

    }
}
