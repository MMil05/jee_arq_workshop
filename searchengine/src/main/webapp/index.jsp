<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html>
<head>
    <title>search engine [index.jsp]</title>
</head>
<body>

<h1>Hello in ISAJEE search engine welcome page!</h1>

<%@ include file="logged-tab.jsp" %>

<c:if test="${errorMessage != null}">
    <div style="color: red;">${errorMessage}</div>
</c:if>
<c:if test="${okMessage != null}">
    <div style="color: green;">${okMessage}</div>
</c:if>

<%@ include file="menu.jsp" %>

<%
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
%>

<div>
    <%=currentTime.format(formatter)%>
</div>

</body>
</html>
