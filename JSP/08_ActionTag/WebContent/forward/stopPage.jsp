<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//result.jsp 로 페이지 이동
%>
<!--redirect 의 경우 페이지 이동시 파라메터는 가져갈 수 없다-->
<!--forward 의 경우 파라메터를 가져갈 수 있다. 추가도 가능하다-->
<!--forward 는 request 객체이기 때문에 파라메터도 수용이 가능한 것이다-->

<!--파라메터도 줄 수 있다, JSP 에서는 태그와 태그 사이에 주석을 넣지 않는다-->
<jsp:forward page="result.jsp">
	<jsp:param name="tel" value="010-1234-1234"/>
</jsp:forward>