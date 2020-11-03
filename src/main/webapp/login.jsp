<%--
  Created by IntelliJ IDEA.
  User: cerapture
  Date: 11/3/20
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String user = request.getParameter("user");
    String pass = request.getParameter("pass");

    request.setAttribute("user", user);
    request.setAttribute("pass", pass);
%>

<html>
<head>
    <title>Login</title>
</head>
<body>

<p>Username passed = <%=request.getParameter("user")%>
</p>
<p>Password passed = <%=request.getParameter("pass")%>
</p>

<form method="POST">
    <h1>Login Here!</h1>
    <label> Username:
        <input type="text" name="user" placeholder="Username">
    </label>
    <label> Password:
        <input type="text" name="pass" placeholder="Password">
    </label>
    <br>
    <button type="submit">Submit</button>
</form>

<c:if test="${user.equals('admin') && pass.equals('password')}">
    <%response.sendRedirect("profile.jsp");%>
</c:if>

</body>
</html>
