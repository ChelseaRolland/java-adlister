<%--
  Created by IntelliJ IDEA.
  User: cerapture
  Date: 11/5/20
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Students</title>
</head>
<body>
<h1>Here are all the Students from Bash!:</h1>

<c:forEach var="student" items="${students}">
    <div class="student">
        <h2>${student.firstname + " " + student.lastname}</h2>
        <p>Cohort: $ ${student.cohort}</p>
    </div>
</c:forEach>

</body>
</html>
