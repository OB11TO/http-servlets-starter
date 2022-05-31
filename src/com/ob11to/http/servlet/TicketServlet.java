package com.ob11to.http.servlet;

import com.ob11to.http.service.TicketService;
import com.ob11to.http.util.JspHelper;
import com.ob11to.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(UrlPath.TICKETS)
public class TicketServlet extends HttpServlet {

    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Для того чтобы принять параметр findByFlightId
        var flightId = Integer.valueOf(req.getParameter("flightId")); //получить параметр запроса

        var ticketDtos = ticketService.findByIdFlightId(flightId);
        req.setAttribute("tickets", ticketDtos);
        req.getRequestDispatcher(JspHelper.getPath("tickets"))
                .forward(req,resp);


//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        try (var respWriter = resp.getWriter()) {
//            respWriter.write("<h1>Купленные билеты:</h1>");
//            respWriter.write("<ul>");
//            ticketService.findByIdFlightId(flightId)
//                    .forEach(ticketDto -> respWriter.write(
//                            """
//                             <li>
//                                  %s
//                             </li>
//                             """.formatted(ticketDto.getSeatNo())
//                    ));
//            respWriter.write("</ul>");
//        }


//        //findByAll
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        try (var printWriter = resp.getWriter()) {
//            printWriter.write("<h1Список билетов/h1>");
//            printWriter.write("<ul>");
//            ticketService.findAll()
//                    .forEach(ticketDto -> {
//                        printWriter.write("""
//                                <li>
//                                %s - %s - %s - %s - %s - %s
//                                </li>
//                                """.formatted(ticketDto.getId(),
//                                ticketDto.getPassengerNo(),
//                                ticketDto.getPassengerName(),
//                                ticketDto.getFlightId(),
//                                ticketDto.getSeatNo(),
//                                ticketDto.getCost()));
//                    });
//            printWriter.write("</ul>");
//        }

    }
}
