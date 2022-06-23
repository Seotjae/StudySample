<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td {
		border : 1px solid black;
		border-collapse: collapse;
		padding: 10px;
	}
</style>
</head>
<body>
	<form action="jsUse.jsp" method="post"> <!--client 에서 server 로 데이터와 요청을 보낸다 -->
		<table>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="userName"/>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="male"/>남자
					<input type="radio" name="gender" value="female"/>여자
				</td>
			</tr>			
			<tr>
				<td>취미</td> <!--취미는 여러개-->
				<td>
					<input type="checkbox" name="hobby" value="독서"/>독서
					<input type="checkbox" name="hobby" value="게임"/>게임
					<input type="checkbox" name="hobby" value="축구"/>축구
					<input type="checkbox" name="hobby" value="영화"/>영화
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송"/>
				</td>
			</tr>			
		</table>
	</form>
</body>
</html>