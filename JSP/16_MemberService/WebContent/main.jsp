<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//로그인이 되어있지 않다면 index.jsp 로 돌려보내기
	//로그인 여부를 확인하려면 세션의 로그인 속성의 값을 확인해야 한다
	String loginId = (String)session.getAttribute("loginId");
	System.out.println("로그인 여부 : "+loginId);
	if(loginId == null){
		response.sendRedirect("index.jsp");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 성공 화면</h1>
	<p>
		<%=loginId%> 님 반갑습니다.
		<button onclick="location.href='logout.jsp'">로그아웃</button>
	</p>
	<!--회원 리스트 보여주기-->
	<!--회원 리스트 불러오는 페이지를 include-->
	<jsp:include page="memberList.jsp"/>
</body>
</html>