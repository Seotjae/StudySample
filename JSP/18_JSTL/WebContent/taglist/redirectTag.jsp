<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>redirect 태그에서는 절대경로 입력 시 c:url 처럼 컨텍스트 경로를 포함하게 된다</li>
		<li>url 에는 이동할 페이지 주소를 넣는다</li>
		<li>c:redirect 는 get 방식으로 파라메터를 추가해 줄 수 있다</li>
	</ul>
	<c:redirect url="/taglist/chooseTag.jsp">
		<c:param name="num">1</c:param>
	</c:redirect>
</body>
</html>