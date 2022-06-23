<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td{
		border : 1px solid black;
		border-collapse: collapse;
		padding : 5px;
	}
	.btn{
		text-align: center;
	}
</style>
</head>
<body>
	<form action="loginResult.jsp" method="post"> <!-- form 태그안에 있는 내용을 action 의 경로로 post 방식으로 데이터를 전송하겠다  -->
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"/></td> <!-- 아이디는 id 라는 name으로 -->
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"/></td> <!-- 비밀번호는 pw 라는 name으로 -->
			</tr>
			<tr>
				<td colspan="2" class="btn"><input type="submit" value="login"/></td> <!-- submit 인 login 버튼을 누르면 데이터가 전송된다 -->
			</tr>
		</table>
	</form>
	
</body>
</html>