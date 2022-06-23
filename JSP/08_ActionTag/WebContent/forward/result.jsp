<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>이름 : <%=request.getParameter("name")%></li>
		<li>나이 : <%=request.getParameter("age")%></li>
		<li>주소 : <%=request.getParameter("address")%></li>
		<li>전화 : <%=request.getParameter("tel")%></li>
	</ul>
</body>
</html>