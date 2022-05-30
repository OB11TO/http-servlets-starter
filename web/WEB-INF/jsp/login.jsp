<%--
  Created by IntelliJ IDEA.
  User: obiito
  Date: 30.05.2022
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="emailId">
            <input type="text" name="email" id="emailId" value="${param.email}">
        </label><br>
        <label for="passwordId">
            <input type="password" name="password" id="passwordId">
        </label><br>
        <button type="submit">Login</button>
        <a href="${pageContext.request.contextPath}/registration">
            <button type="button">Register</button>
        </a>
        <c:if test="${param.error != null}">
            <div style="color: red">
                <span>EMAIL ERROR</span>
            </div>
        </c:if>
        
    </form>
</body>
</html>
