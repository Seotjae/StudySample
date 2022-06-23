<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Application 영역에 저장된 정보</h2>
	<p>ID : <%=application.getAttribute("id")%></p>
	<p>NAME : <%=application.getAttribute("name")%></p>
	<hr/>
	<h2>Session 영역에 저장된 정보</h2>
	<p>E-MAIL : <%=session.getAttribute("email")%></p>
	<p>PHONE : <%=session.getAttribute("phone")%></p>
</body>
</html>