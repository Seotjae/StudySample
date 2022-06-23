<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int maxAge = session.getMaxInactiveInterval(); //세션 수명
	String value = (String) session.getAttribute("msg"); //msg 에 대한 값 가져오기 value 가 Object 라 캐스팅을 해줘야 함	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>세션의 만료 기간 : <%=maxAge%></p>
	<p>세션에 저장된 msg 속성에 대한 값 : <%=value%></p> <!--쿠키와 다르게 세션은 하나이고 그 안에 속성과 속성 값을 저장-->
	<p>세션 ID : <%=session.getId()%></p> <!--세션이 생성될 때 가지는 고유 아이디-->
	
	<h2>세션 테스트</h2>
	<a href="sessionSet.jsp">세션에 값 저장</a>
	<a href="sessionDel.jsp">세션에 값 삭제</a>
	<a href="sessionInit.jsp">세션 초기화</a> <!--세션이 아예 지워지는 것, 아이디가 바뀜-->
	<br/>
	<a href="example/login.jsp">로그인 예제</a>
</body>
</html>