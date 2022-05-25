<%--
  Created by IntelliJ IDEA.
  User: obiito
  Date: 25.05.2022
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>FlightJspServlet</title>
</head>
<body>
      <h1>Список перелетов</h1>
        <ul>
            <c:forEach var="flight" items="${requestScope.flights}">
               <li>
                    <a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}">${flight.description}</a>
               </li>
            </c:forEach>
        </ul>
</body>
</html>
