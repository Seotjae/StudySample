<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="firstBean" class="com.beans.FirstBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>firstBean 의 name 속성의 값을 출력 : <%=firstBean.getName()%></p>
	<p>firstBean 의 name 속성의 값을 출력 : <jsp:getProperty name="firstBean" property="name"/></p>
</body>
</html>