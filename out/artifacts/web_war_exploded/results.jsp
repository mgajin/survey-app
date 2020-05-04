<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="java.util.*" %>
<%@ page import="main.java.model.Database" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Survey Results</title>
</head>
<body>

<%
    Database database = (Database) session.getServletContext().getAttribute("database");
    pageContext.setAttribute("database", database);
%>

<main class="container">
    <h2>Survey Results</h2>

    <div class="border">

        <c:choose>
            <c:when test="${fn:length(database.assistants) > 0}">
                <c:forEach var="assistant" items="${database.assistants}">
                    <h5>${assistant.toString()}: ${assistant.averageScore}</h5>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h1>Empty!</h1>
            </c:otherwise>
        </c:choose>

<%--        <c:if test="${fn:length(database.assistants) == 0}">--%>
<%--            <h1>Empty!</h1>--%>
<%--        </c:if>--%>
<%--        <c:if test="${fn:length(database.assistants) > 0}" >--%>
<%--            <c:forEach var="assistant" items="${database.assistants}">--%>
<%--                <h5>${assistant.toString()}: ${assistant.averageScore}</h5>--%>
<%--            </c:forEach>--%>
<%--        </c:if>--%>

    </div>

    <a href="http://localhost:8080/">GO BACK</a>
</main>
</body>
<style>
    main {
        height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    div {
        text-align: justify;
        padding: 2em;
    }
</style>
</html>
