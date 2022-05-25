<%@ page import="com.ob11to.http.service.TicketService" %>
<%@ page import="com.ob11to.http.dto.TicketDto" %>
<%@ page import="java.util.List" %><%-- АТРИБУТ import
  Created by IntelliJ IDEA.
  User: obiito
  Date: 25.05.2022
  Time: 11:07
  To change this template use File | Settings | File Templates.


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>  <%--директива--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Купленные билеты:</h1>
<ul>
    <c:forEach var="ticket" items="${requestScope.tickets}">
        <li>
           ${fn:toLowerCase(ticket.seatNo)}
        </li>
    </c:forEach>
</ul>
</body>
</html>
