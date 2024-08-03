<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>user deletion</title>
</head>
<body>

  <c:if test="${result==1}">
 <h1>data deleted successfully....<%=request.getParameter("mobile")  %></h1>
 <a href="home.html"> click to go to homepage</a>
</c:if>

<c:if test="${result==0}">
<h1>data not available with given number<%=request.getParameter("mobile")  %></h1>
<jsp:include page="userdelete.html"></jsp:include>
</c:if>
</body>
</html>

