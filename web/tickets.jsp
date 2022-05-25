<%@ page import="com.ob11to.http.service.TicketService" %>
<%@ page import="com.ob11to.http.dto.TicketDto" %>
<%@ page import="java.util.List" %><%-- АТРИБУТ import
  Created by IntelliJ IDEA.
  User: obiito
  Date: 25.05.2022
  Time: 11:07
  To change this template use File | Settings | File Templates.


  ЭТО ПЛОХОЙ ПРИМЕР, ТАК ДЕЛАТЬ НЕ НУЖНО. СКРИПЛЕТЫ ДАВНО УЖЕ НЕ ИСПОЛЬУЮТСЯ!!!!!
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>  <%--директива--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Купленные билеты:</h1>
<ul>
    <%
        Integer flightId = Integer.valueOf(request.getParameter("flightId"));
        TicketService ticketService = TicketService.getInstance();
        List<TicketDto> byIdFlightId = ticketService.findByIdFlightId(flightId);
        for(TicketDto ticket : byIdFlightId){
            out.write(String.format("<li>$s</li>", ticket.getSeatNo()));
        }
       
    %>
</ul>
</body>
</html>
