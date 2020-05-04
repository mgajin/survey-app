<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%--Bootstrap--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Survey Page</title>
  </head>
  <body>
  <main class="container border">
    <form action="http://localhost:8080/survey" method="post">
      <div class="form-group">
        <label for="nameInput">Name</label>
        <input type="text" name="name" class="form-control" id="nameInput" placeholder="Type name">
      </div>
      <div class="form-group">
        <label for="surnameInput">Surname</label>
        <input type="text" name="surname" class="form-control" id="surnameInput" placeholder="Type surname">
      </div>
      <div class="form-group">
        <label for="selectScore">Select score</label>
        <select class="form-control" name="rating" id="selectScore">
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <a href="http://localhost:8080/results">See ratings</a>
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
  </style>
</html>