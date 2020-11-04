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
    if (request.getMethod().equalsIgnoreCase("post")){
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        request.setAttribute("user", user);
        request.setAttribute("pass", pass);

        if (user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login Page"/>
    </jsp:include>
</head>
<body>
<%--<%@ include file="partials/navbar.jsp" %>--%>
<jsp:include page="partials/navbar.jsp" />

<p>Username passed = <%=request.getParameter("user")%>
</p>
<p>Password passed = <%=request.getParameter("pass")%>
</p>

<h1>Login Here!</h1>
<form method="POST" action="login.jsp">
    <label> Username:
        <input type="text" name="user" placeholder="Username">
    </label>
    <label> Password:
        <input type="password" name="pass" placeholder="Password">
    </label>
    <br>
    <button type="submit">Submit</button>
</form>

<%--<c:if test="${user.equalsIgnoreCase('admin') && pass.equalsIgnoreCase('password')}">--%>
<%--    <%response.sendRedirect("profile.jsp");%>--%>
<%--</c:if>--%>

</body>
</html>
