<%@ page import="main.java.model.Assistant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="assistant" class="main.java.model.Assistant" scope="request"/>--%>
<jsp:useBean id="database" class="main.java.model.Database" scope="application"/>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Survey Results</title>
</head>
<body>

<main class="container border">


<%--    ${database.assistants}--%>

    <% if (!database.getAssistants().isEmpty()) {
       for (Assistant ass : database.getAssistants()) {%>
            <%= ass.toString() + ": " + ass.getAverageScore()%>
        <% } %>
    <%} else { %>
        empty
    <%}%>

    <a href="http://localhost:8080/survey">Rate assistant</a>
</main>


</body>
</html>
