<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//쿠키는 PC(client) 에 저장되므로 불러올 때 request 를, 저장할 때 response 를 사용한다
	//cookie 의 값에는 콤마 (,) 가 있으면 에러가 발생한다. (그러므로 구분자는 다른것을 줄 것 : 1_2_3)
	Cookie cookie = new Cookie("name","최성재"); //name 과 value 가  String 형태로 들어간다
	
	cookie.setMaxAge(60*10); //유효기간 (저장기간 : 초 단위) -> 10분
	response.addCookie(cookie); //쿠키 저장
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>쿠키 이름 : <%=cookie.getName()%></p>
	<p>쿠키 값 : <%=cookie.getValue()%></p>
	<p>쿠키 만료시간 : <%=cookie.getMaxAge()%></p>
	<a href="result.jsp">다른 페이지에서 쿠키에 저장된 값을 불러오기</a>
	<br/>
	<a href="example/infoinput.jsp">쿠키 예제</a>
	
</body>
</html>