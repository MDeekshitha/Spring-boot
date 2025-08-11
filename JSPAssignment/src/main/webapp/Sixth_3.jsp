<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Getting session</h1>
<%
String name = (String)session.getAttribute("name");
%>
<b>Session value <%= name %></b>
<%
String password = (String)session.getAttribute("password");
%>
<b>Session value <%= password %></b>
</body>
</html>