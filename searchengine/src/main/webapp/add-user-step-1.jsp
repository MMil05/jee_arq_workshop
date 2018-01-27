<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search engine [add-user-step-1.jsp]</title>
</head>
<body>

<c:if test="${errorMessage != null}">
    <div style="color: red;">${errorMessage}</div>
</c:if>
<c:if test="${okMessage != null}">
    <div style="color: green;">${okMessage}</div>
</c:if>

<form method="post" action="/add-user-steps">
    <input type="hidden" name="step" value="1"/>
    <label>Login:</label><input name="login" type="text"/><br/><br/>
    <input type="submit" name="add-user" value="next >"/>
</form>

</body>
</html>
