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
		<li>c:choose 는 java 의 switch 와 비슷하다</li>
		<li>c:when 은 case 와 같다고 생각하면 된다</li>
		<li>c:otherwice 는 default 와 같다고 생각하면 된다 (필수는 아니다)</li>
		
		<!-- index.jsp 에서 넘겨온 값으로 각각 다른 메시지가 출력되도록 -->
		<!--  request.getparameter 를 쓸 필요가 없다 -->
		<c:choose>
			<c:when test="${param.num == '0'}">
				<h3>parameter 값은 0 입니다.</h3>
			</c:when>
			<c:when test="${param.num eq '1'}">
				<h3>parameter 값은 1 입니다.</h3>
			</c:when>
			<c:when test="${param.num == '2'}">
				<h3>parameter 값은 2 입니다.</h3>
			</c:when>
			<c:otherwise>
				<h3>parameter는 0~2 사이의 값을 입력하세요.</h3>
			</c:otherwise>
		</c:choose>
		
	</ul>
</body>
</html>