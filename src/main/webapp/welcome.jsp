<%--
  Created by IntelliJ IDEA.
  User: cerapture
  Date: 11/3/20
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%! String name = ""; %>
<% name = "Chelsea".toUpperCase(); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<h1>Hello my name is : <%= name%> </h1>

<h1>Welcome To The Site!</h1>
<p>Path: <%= request.getRequestURL() %></p>
<p>Query String: <%= request.getQueryString() %></p>
<p>"name" parameter: <%= request.getParameter("name") %></p>
<p>"name" parameter with EL: ${param.name}</p>
<p>"age" parameter: <%= request.getParameter("age") %></p>
<p>"method" attribute: <%= request.getMethod() %></p>
<p>User-Agent header: <%= request.getHeader("user-agent") %></p>
<p>User-Agent header with EL: ${header["user-agent"]}</p>

<%--switch(condition)--%>
<c:choose>
    <c:when test="${param.name == 'Chelsea'}">
        <p>boolean_expression_1 was true</p>
    </c:when>
<%--    else-if--%>
    <c:when test="${param.name != 'Chelsea'}">
        <p>boolean_expression_1 was false, and boolean_expression_2 was true</p>
    </c:when>
<%--    else-if--%>
    <c:otherwise>
        <p>none of the above tests were true</p>
    </c:otherwise>
</c:choose>

<% request.setAttribute("message", "Hello, World!"); %>
<h1>Here is the message: ${message}</h1>

<%request.setAttribute("price", 45.57);%>

<%--Yes or No Questions so single if statements--%>
<c:if test="${price > 40}">
    <p>Too Expensive</p>
</c:if>
<c:if test="${price < 40}">
    <p>Just right and in the budget!</p>
</c:if>

<table border="1px">
    <thead>
    <tr>
        <td>Name</td>
        <td>Price</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Tool</td>
        <td>$${price}</td>
    </tr>
    </tbody>
</table>

<% request.setAttribute("numbers", new int [] {1,2,3,4,5,6,7}); %>

<ul>
<%--    refactor below to choose statement so it will not repeat the conditional number--%>
    <c:forEach var="number" items="${numbers}">

        <c:if test="${number == 5}">
            <li style="color:mediumvioletred">${number}</li>
        </c:if>

        <c:if test="${number == 3}">
            <li style="color:dodgerblue">${number}</li>
        </c:if>

        <c:if test="${number != 3 && number != 5}">
            <li>${number}</li>
        </c:if>

<%--        <li>${number}</li>--%>
    </c:forEach>
</ul>


</body>
</html>
