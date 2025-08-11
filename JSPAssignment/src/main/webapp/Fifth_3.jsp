<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name");
%>
Welcome <%= name %>
<%
session.setAttribute("name",name);
%>
<%
String password = request.getParameter("password");
%>
<%
session.setAttribute("password",password);
%>
<p><a href="Sixth.jsp">Get Session</a></p>
</body>
</html>