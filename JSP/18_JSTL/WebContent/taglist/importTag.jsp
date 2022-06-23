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
		<li>action 태그의 include 와 유사하다</li>
		<li>외부의 페이지를 읽어와 포함시킨다</li>
		<li>c:import url="가져올 페이지 주소" var="변수명" scope="영역" charEncoding="캐릭터셋"</li>
	</ul>
	<%-- <jsp:include page="../index.jsp"/> --%>
	<c:import url="../index.jsp"/>
	
	<!-- 외부 사이트 import -->
	<c:import url="https://www.youtube.com/results">
		<c:param name="search_query">jsp</c:param>
	</c:import>

</body>
</html>