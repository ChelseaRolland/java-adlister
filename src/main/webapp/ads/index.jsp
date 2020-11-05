<%--
  Created by IntelliJ IDEA.
  User: cerapture
  Date: 11/5/20
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Ads</title>
</head>
<body>
<h1>Here are all the Ads!</h1>

<c:forEach var="ad" items="${ads}">
    <div class="ad">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
        <hr>
    </div>
</c:forEach>

</body>
</html>
