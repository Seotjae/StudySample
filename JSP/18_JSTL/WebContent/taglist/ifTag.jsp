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
		<li>자바의 if 하고 비슷한 기능을 제공한다</li>
		<li>c:if test="조건"</li>
		<li>c:if test="조건" var="앞의 조건식 결과를 저장할 변수"</li>
	</ul>
	<c:if test="true">
		조건 결과가 true 이면 무조건 태그 안의 내용이 실행된다
	</c:if>

	<c:if test="false">
		조건 결과가 false 이면 무조건 태그 안의 내용이 실행되지 않는다
	</c:if>

	<!-- 변수를 이용한 조건 -->
	<c:set var="myId">${sessionScope.myId}</c:set>
	<c:if test="${myId eq 'admin'}" var="testVar"> <!-- el 태그를 활용해서 조건을 사용할 수 있다 -->
		myId 의 값 : ${myId} <br/>
		\${myId eq 'admin'} 조건의 결과 값 : ${testVar}
	</c:if>
	
	<!-- c:if 는 else 라는 것이 없다 -->
	<c:if test="${myId ne 'admin'}">
		myId 의 값은 admin 이 아닙니다
	</c:if>
</body>
</html>