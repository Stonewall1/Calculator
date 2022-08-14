<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<h3>Calculator App</h3>
<c:if test="${sessionScope.currentUser == null}">
    <a href="/registration" class="btn btn-primary">Registration</a>
    <a href="/login" class="btn btn-primary">Authorization</a>
</c:if>

<c:if test="${sessionScope.currentUser != null}">
    <p>Hello , ${sessionScope.currentUser.name}</p>
    <a href="/calculator" class="btn btn-primary">Calculator</a>
    <a href="/logout" class="btn btn-primary">Logout</a>
    <a href="/story" class="btn btn-primary">History of operations</a>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
