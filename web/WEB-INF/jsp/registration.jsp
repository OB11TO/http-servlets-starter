<%--
  Created by IntelliJ IDEA.
  User: obiito
  Date: 26.05.2022
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
    <label for="name"><br>Name:
        <input type="text" name="username" id="name">
    </label>
    <label><br>Image:
        <input type="file" name="image" id="imageId">
    </label>
    <label><br>Birthday:
        <input type="date" name="birthday" id="date">
    </label>
    <label><br>Email:
        <input type="text" name="email" id="email">
    </label>
    <label><br>Password:
        <input type="password" name="password" id="password">
    </label>
    <label for="rol"></label><br>
    <select name="role" id="rol">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">${role}</option>
        </c:forEach>
    </select><br>
    <c:forEach var="gender" items="${requestScope.genders}">
        <label>
            <input type="radio" name="gender" value="${gender}">
        </label>${gender}
        <br>
    </c:forEach>
    <button type="submit">
        Send
    </button>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var ="error" items="${requestScope.errors}">
                <span>${error.code}</span>
                <span>${error.code}</span>
                <br>
            </c:forEach>
        </div>
    </c:if>

</form>
</body>
</html>
