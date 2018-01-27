<c:choose>
    <c:when test="${not empty sessionScope.isLogged && sessionScope.isLogged == true}">
        <div>Zalogowany jako: ${sessionScope.loggedUser} [<a href="<c:url value="/logout"/>">Wyloguj</a>]</div>
    </c:when>
    <c:otherwise>
        <div>[<a href="<c:url value="login.jsp"/>">Zaloguj</a>]</div>
    </c:otherwise>
</c:choose>