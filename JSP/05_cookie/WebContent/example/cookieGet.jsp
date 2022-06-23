<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String lang = "";
	Cookie[] cookies = request.getCookies();//1. 쿠키를 받아온다
	for(Cookie cookie:cookies){
		if(cookie.getName().equals("lang")){//2. 쿠키들 중 name 이 lang 인 녀석을 찾는다
			lang = cookie.getValue(); //name 이 lang 인 쿠키의 값을 lang 변수에 담는다
		//3. 쿠키 값을 통해
		//4. 사용한 쿠키는 지운다 (지우는 법을 배우기 위해 일부러 넣음)
		//쿠키를 지우는 방식 : 유효기간을 0초로 줘서 저장한다.
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(lang.equals("kor")){%>
		<h2>한글 페이지에 오신 것을 환영합니다.</h2>
	<%}else{%>
		<h2>Welcome to English Page.</h2>
	<%}%>
</body>
</html>