<%@ page language="java" contentType="text/html"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Search result</title>
</head>
<body bgcolor="pink">
 
 <c:if test="${not empty userinfo}">
 <h1>data found successfully....</h1>
 User Name...${userinfo.username }<br><br>
  User password...${userinfo.password }<br><br>
   User email...${userinfo.email }<br><br>
    User mobile...${userinfo.mobile }<br><br>
   <a href="home.html">click here to go to homepage</a>
 </c:if>

  
</body>

</html>