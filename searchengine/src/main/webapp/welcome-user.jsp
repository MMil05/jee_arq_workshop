<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>search engine [welcome-user.jsp]</title>
</head>
<body>
<%@ include file="go-back.jsp"%>
Hello from request scope ${name}!<br/>
Hello from session scope ${sessionScope.sessionName}!<br/>

Salary ${salary}<br/>

<c:set var="bonus" scope="request" value="${salary*1.20}"/>

<c:out value="Your salary with bonus is: ${bonus}."/><br/>

</body>
</html>
