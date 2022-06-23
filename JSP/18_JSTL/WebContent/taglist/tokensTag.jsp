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
		<li>Tokenizer 기능과 비슷하다 (split)</li>
		<li>c:forTokens var="변수명" items="대상 문자열" delims="구분자"</li>
		<li>items 에 있는 문자열을 delims 의 구분자를 기준으로 나눠서 var 에 있는 변수에 넣는다</li>
	</ul>
	<c:set var="text">축구,야구,농구,배구,골프,수영</c:set>
	<c:forTokens var="sports" items="${text}" delims=",">
		${sports}
	</c:forTokens>
	
	<br/>
	<!-- 토마토^귤^포도^오렌지^복숭아 -->
	<c:forTokens var="fruit" items="토마토^귤^포도^오렌지^복숭아" delims="^">
		${fruit}
	</c:forTokens>
</body>
</html>