<%--
  Created by IntelliJ IDEA.
  User: obiito
  Date: 25.05.2022
  Time: 12:44
  To change this template use File | Settings | File Templates.

  Тэги:
  <span> - для текста
  <p> - абзац

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Content ob11to</title>
</head>
<body>
    <%@include file="header.jsp" %>
    <span>Content</span>
    <p>Size: ${requestScope.flights.size()}</p>  <%-- размер --%>
    <p>Id req: ${requestScope.flights[1].id}</p> <%--  --%>
    <p>Id session: ${sessionScope.flightsMap[0]}</p>

    <p>JSESSIONID: ${cookie["JSESSIONID"]}</p>  <%-- индентификатор сесии --%>
    <p>Header: ${header["cookie"]}</p>  <%-- JSESSIONID всю строку куки --%>
    <p>Param id: ${param.id}</p>
    <p>Param test: ${param.test}</p>
    <p>Empty list: ${requestScope.flights}</p>
    <%@include file="footer.jsp" %>
</body>
</html>
