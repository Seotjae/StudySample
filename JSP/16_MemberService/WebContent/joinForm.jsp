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
		<h2>회원 가입</h2>
		<form action="joinProc.jsp" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="userId"/></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="userPass"/></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" name="userName"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						남자: <input type="radio" name="gender" value="남"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						여자: <input type="radio" name="gender" value="여"/>
					</td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="email" name="email"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="회원가입"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script></script>
</html>