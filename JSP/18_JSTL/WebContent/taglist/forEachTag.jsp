<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] sports = {"축구","야구","농구","골프","수영","볼링",};
	HashMap<String,String> map = new HashMap<>();
	map.put("name","kim");
	map.put("age","37");
	map.put("mobile","010-2034-3054");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>c:forEach 는 array 와 Collection Framework 에 저장된 내용을 하나씩 뽑아서 사용할 때 유용하다</li>
		<li>c:forEach var="변수" items="아이템" begin="시작값" end="끝값" step="증가값"</li>
		<li>item 에 하나씩 뽑을 대상을 넣는다 (배열, 맵 등등 ...)</li>
	</ul>
	
	<!-- forEach 를 일반 for 문처럼 활용 (이런 방식으로는 잘 사용하지 않는다)-->
	<c:forEach var="i" begin="1" end="10" step="1">${i}</c:forEach>
	
	<h1>1 부터 100 까지의 합</h1>
	<c:set var="sum">0</c:set>
	<c:forEach var="i" begin="1" end="100" step="1">
		<c:set var="sum" value="${sum+i}"/>
	</c:forEach>
	<h1>답 : ${sum}</h1>
	
	<hr/>
	<!-- 실제 사용하는 방식 -->
	<h1>실제 사용하는 방식</h1>
	<h3>**sports 배열에 있는 값을 하나씩 뽑아오기</h3>
	<c:forEach var="i" items="<%=sports%>" varStatus="stat">
		${stat.index}:${i}
	</c:forEach>
	
	<h3>sports 배열에 있는 1~3번 인덱스의 값을 하나씩 뽑아오기</h3>
	<c:forEach var="i" items="<%=sports%>" begin="1" end="3" step="1" varStatus="stat">
		${stat.index}:${i}
	</c:forEach>
	
	<h3>map 에 있는 값 뽑기</h3>
	<c:forEach var="item" items="<%=map%>">
		${item.key} : ${item.value}<br/>
	</c:forEach>
	
	
	
</body>
</html>