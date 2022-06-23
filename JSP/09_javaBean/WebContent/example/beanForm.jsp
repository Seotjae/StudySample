<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--method 를 생략하면 기본 get-->
	<form action="beanProc.jsp">
		이름 : <input type="text" name="userName" />
		<button>전송</button> <!--button 태그는 form 안에 있으면 submit 역할을 한다-->
	</form>
</body>
</html>