<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form action="/calculator" method="post">
    <input type="number" name="x1" placeholder="Input first number">
    <input type="number" name="x2" placeholder="Input second number">
    <input type="text" name="operation" placeholder="Operation">
    <button>Submit</button>
</form>
<p>${result}</p>

</body>
</html>
