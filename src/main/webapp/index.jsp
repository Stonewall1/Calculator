<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

<h3>Calculator App</h3>
<c:if test="${sessionScope.currentUser == null}">
    <a href="/registration">Registration</a>
    <a href="/login">Authorization</a>
</c:if>

<c:if test="${sessionScope.currentUser != null}">
    <p>Hello , ${sessionScope.currentUser.name}</p>
    <a href="/calculator">Calculator</a>
    <a href="/logout">Logout</a>
</c:if>

</body>
</html>
