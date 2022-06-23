<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>언어를 설정해 주세요</h3>
	<form action="cookieSet.jsp" method="post">	
		<input type="radio" name="lang" value="kor" checked/>한국어 <!--선택을 안할수도 있으니 기본 선택을 해준다-->
		<input type="radio" name="lang" value="eng"/>English
		<input type="submit" value="설정"/>	
	</form>
</body>
</html>