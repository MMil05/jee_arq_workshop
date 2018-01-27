<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search engine [login.jsp]</title>
</head>
<body>
<%@ include file="go-back.jsp" %>
<h1>Zaloguj:</h1>
<form method="post" action="/login">
    <label for="j_username">Login:</label>
    <input type="text" id="j_username" name="j_username"/><br/>
    <label for="j_password">Password:</label>
    <input type="password" id="j_password" name="j_password"/><br/>
    <input type="submit" value="login" name="login"/>
</form>
</body>
</html>
