<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//1. PC(client) 에서 '모든' 쿠키 객체를 받아온다
	Cookie[] cookies = request.getCookies();
	//쿠키 객체는 하나의 이름과 값 밖에 가질 수 없기 때문에 여러 값을 저장하기 위해서는 여러개의 쿠키를 만들어야 한다
	//그래서 여러 개를 만들지 않고 쿠키를 배열로 가져오는 것이다
	
	String key="";
	String value="";
	//2. 쿠키 배열에서 원하는 쿠키 객체를 찾는다
	if(cookies.length>0){ //쿠키가 존재할 경우 (거의 드물지만 쿠키가 없는 경우가 있음)
		for(Cookie cookie:cookies){
			//System.out.println(cookie.getName()+" = "+cookie.getValue());
			//내가 만든것만 찾아서 출력해 보기
			if(cookie.getName().equals("name")){
			System.out.println(cookie.getName()+" = "+cookie.getValue());
			key = cookie.getName();
			value = cookie.getValue();
			}
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
	<h2><%=key%> : <%=value%></h2>
</body>
</html>