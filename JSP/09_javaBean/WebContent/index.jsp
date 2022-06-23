<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--id="호출할 이름" class="빈의 위치(클래스 포함)" scope="빈의 사용 영역(page, request, session, application)"-->
<jsp:useBean id="firstBean" class="com.beans.FirstBean" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JAVA Bean 사용 예제</h2>
	<h3><%=firstBean.getName()%></h3>
	<a href="example/beanForm.jsp">빈 사용 예제</a>
</body>
</html>