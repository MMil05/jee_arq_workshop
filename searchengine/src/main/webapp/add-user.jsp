<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search engine [add-user.jsp]</title>
</head>
<body>

<%@ include file="go-back.jsp" %>

<h1>Add new user via one-step formula</h1>

<form method="post" action="/add-user">
    <label>ID:</label><input name="id" type="text"/><br/><br/>
    <label>Name:</label><input name="name" type="text"/><br/><br/>
    <label>Surname:</label><input name="surname" type="text"/><br/><br/>
    <label>Login:</label><input name="login" type="text"/><br/><br/>
    <label>Age:</label><input name="age" type="text"/><br/><br/>
    <label>Gender:</label>
    <select name="gender">
        <option value="">&lt;select&gt;</option>
        <option value="MAN">MAN</option>
        <option value="WOMAN">WOMAN</option>
    </select>
    <input type="submit" name="add-user" value="add-user"/>
</form>

</body>
</html>
