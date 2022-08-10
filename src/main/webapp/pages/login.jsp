<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.08.2022
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="/login" method="post">
    <input type="email" name="email" placeholder="Enter email"/>
    <input type="password" name="password" placeholder="Enter password"/>
    <button>Login</button>
</form>
<p>${message}</p>

</body>
</html>
