<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//파라메터를 받아서 어플리케이션 영역에 저장하기
	//1. 파라메터 받기
	request.setCharacterEncoding("UTF-8");
	String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");
	
	//2. application 영역에 저장 (값을 넣고 지우고 하는 방식들이 session 과 동일)
	application.setAttribute("id", userId);
	application.setAttribute("name",userName);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="session.jsp" method="post">
		<table>
			<tr>
				<td colspan="2">Session 에 저장될 내용</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="cellphone"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"/></td>
			</tr>
		</table>
	</form>
</body>
</html>