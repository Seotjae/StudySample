<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
		<style>
			table, td{
				border : 1px solid black;
				border-collapse: collapse;
			}
			td{
				padding: 5px;
				text-align:center;
			}
		</style>
	</head>
	<body>
		<h2>회원 관리 로그인</h2>
		<form action="loginProc.jsp" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="pass"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="login"/>
						<input type="button" value="회원가입" 
						onclick="location.href='joinForm.jsp'"/>
					</td>
				</tr>
			</table>
		</form>		
	</body>
	<script></script>
</html>