<!-- 페이지 속성 선언 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div.header{ /*include 하면 하나의 페이지로 인식하기 때문에 스타일도 줄 수 있다 */
		background-color: green;
	}
</style>
</head>
<body>
	<%@include file="header.jsp"%> <!-- 헤더 불러오기 (페이지 속성 선언)-->
	<ul>
		<%for(int i=1; i<=10; i++){%> <!-- java 영역으로 표시 -->
		<li><%=i%></li> <!-- java 변수 출력 -->
		<%}%>
	</ul>
	<%@include file="footer.jsp"%> <!-- 푸터 불러오기 -->

</body>
</html>