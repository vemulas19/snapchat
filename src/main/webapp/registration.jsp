<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red"><%=request.getAttribute("error")==null ?"":request.getAttribute("error") %></font>
<form action="test" method="post">
Username:<input type="text" name="uname"/><br>
Email:<input type="text" name="mail"/><br>
Mobileno:<input type="text" name="mob"/><br>
Gender:<input type="text" name="gender"/><br>
Password:<input type="password" name="pwd"/><br>
<input type="submit" value="Register"/>
</form>
<a href="Login.jsp">Login</a>
</body>
</html>