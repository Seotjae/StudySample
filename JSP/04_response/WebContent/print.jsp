<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 페이지 출력은 총 3가지로 할 수 있다 -->
	<%="<p>첫번째, 스크립틀릿 출력문을 활용하는 방법</p>" %> <!--여러 방법을 섞어쓰면 순서가 뒤바뀔 수 있으니 하나만 쓰자-->
	<%out.print("<p>두번째, out 객체를 활용한 print</p>");%> <!--out 객체는 response 로 부터 추출되어 나온 객체이므로 순서가 가장 늦다-->
	<%response.getWriter().write("<p>세번째,response 객체를 활용한 방법</p>");%> <!--response 는 응답 전용이기 때문에 가장 빠르다-->
</body>
</html>