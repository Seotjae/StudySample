<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- C: 로 시작하는 태그가 무엇인지 어떤 역할을 하는지에 대한 정의가 있는 장소 (우린 보통 DTD 라고 부른다) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	session.setAttribute("myId","admin");
	session.setAttribute("uId","105784");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL 에서 사용할 변수 생성 (C 태그 안에서 EL 태그로 무언가 하고 싶다면 set 으로 변수를 선언해야 한다) -->
	<%--
	<c:set var="변수명" value="값" [scope="영역"]/> 
	<c:set var="변수명" [scope="영역"]>값</c:set>
	--%>
	<h3>set tag option</h3>
	<ul>
		<li>var : el 변수의 이름</li>
		<li>value : 변수에 담을 값</li>
		<li>scope : 변수 값을 담을 영역 (*page,request,session,application)</li>
		<li>target : 프로퍼티 값을 설정할 대상 객체 (자바빈 이나 Map)</li>
	</ul>
	<!-- value 속성 사용 -->
	<c:set var="name1" value="test" scope="page"/>
	<c:set var="name2" value="${sessionScope.myId}" scope="page"/>
	<c:set var="name3" value="${sessionScope.myId}_${sessionScope.uId}" scope="request"/>
	
	<!-- 태그 몸체 사용 -->
	<!-- 몸체를 사용하는 방법은 그냥 value 값이 태그와 태그 사이에 들어간 형태라고 생각하면 된다 -->
	<!-- 위와 같은 값인데 표현만 다르게 -->
	<c:set var="name4" scope="page">test</c:set>
	<c:set var="name5" scope="page">${sessionScope.myId}</c:set>
	<c:set var="name6" scope="request">${sessionScope.myId}_${sessionScope.uId}</c:set>
	
	<!-- 위 두 방법 중 본인 취향대로 사용 -->
	<h3>변수 리스트</h3>
	<ul>
		<li>${name1}</li>
		<li>${name2}</li>
		<li>${name3}</li>
		<li>${name4}</li>
		<li>${name5}</li>
		<li>${name6}</li>
	</ul>	
	
	<!-- 변수 삭제 -->
	<%-- <c:remove var="변수명" scope="영역"/> --%>
	<c:remove var="name3" scope="request"/>
	<c:remove var="name4"/>
	<h3>삭제 후 변수 리스트</h3>
	<ul>
		<li>${name1}</li>
		<li>${name2}</li>
		<li>${name3}</li>
		<li>${name4}</li>
		<li>${name5}</li>
		<li>${name6}</li>
	</ul>		
</body>
</html>