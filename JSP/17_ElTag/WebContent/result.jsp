<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.setAttribute("sessionId", session.getId());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	스크립틀릿 : <%=request.getParameter("userId") %>
	<br/>
	EL TAG : ${param.userId}
	<hr/>
	스크립틀릿 : <%=session.getAttribute("sessionId")%>
	<br/>
	EL TAG : ${sessionScope.sessionId}
</body>
</html>