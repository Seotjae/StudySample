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
		<li>URL 생성을 한다</li>
		<li>var 와 scope 생략이 가능하다</li>
		<li>var 속성이 지정되지 않았을 경우 현재 위치에 생성한 URL 을 출력한다</li>
		<li>c:parm 태그를 통해 파라메터를 추가할 수 있다</li>
		<li>**value 속성은 절대URL 또는 상대URL 을 입력할 수 있다</li>
	</ul>
	
	<!-- https://search.daum.net/search?w=blog&q=독도 -->
	<!-- var 속성을 지정하지 않으면 그대로 출력 -->
	<c:url value="https://search.daum.net/search">
		<c:param name="w">blog</c:param>
		<c:param name="q">독도</c:param>
	</c:url>
	
	<c:url value="https://search.daum.net/search" var="searchURL">
		<c:param name="w">blog</c:param>
		<c:param name="q">독도</c:param>
	</c:url>
	
	<p>searchURL 변수에 담긴 값 : ${searchURL}</p>
	
	<!-- 
	상대 경로 여부는 . 이 찍혀 있는지 여부로 알 수 있음 
	./ 현재 (생략이 가능)
	../ 한단계 위
	-->
	<ul>
		<li><c:url value="urlTag.jsp"/></li> <!-- 상대경로 (./ 생략) -->
		<li><c:url value="./urlTag.jsp"/></li> <!-- 상대경로 (현재 폴더의 urlTag.jsp) -->
		<li><c:url value="../index.jsp"/></li> <!-- 상대경로 (윗 폴더의 index.jsp) -->
		<li><c:url value="/index.jsp"/></lyi> <!-- 절대경로 (프로젝트 최 상단의 index.jsp) -->
	</ul>
	
	<ul>
	<!-- c:url 사용 여부에 상관없이 상대경로는 똑같이 작동 -->
		<li><a href="<c:url value='../index.jsp'/>">c:url 상대경로</a></li>
		<li><a href="../index.jsp">상대경로</a></li>
		
		<!-- c:url 절대경로 -> http://localhost:8080/18_JSTL/index.jsp, context(프로젝트 명)을 인식해서 포함 시킨다-->
		<li><a href="<c:url value='/index.jsp'/>">c:url 절대경로</a></li> 
		
		<!-- 절대경로 : http://localhost:8080/index.jsp, context(프로젝트 명)을 인식하지 않는다-->
		<li><a href="/index.jsp">절대경로</a></li>
	</ul>
	<p>절대 경로 사용시 c:url 을 사용하는 것이 좋다</p>
	
</body>
</html>