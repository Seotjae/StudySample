<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<link rel="stylesheet" href="resources/css/common.css" type="text/css">
	<style>
	</style>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" id="pw"></td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" id="login" value="LOGIN"/>
				<input type="button" value="회원가입" onclick="location.href='joinForm'"/>
			</th>
		</tr>
	</table>

</body>
<script>
	$('#login').click(function() {
		console.log('login 클릭');
		var $id = $('#id').val();
		var $pw = $('#pw').val();
		console.log("입력한 아이디/패스워드 : "+$id+"/"+$pw);
		
		if ($id == '') {
			alert('아이디를 입력해 주세요.');
			$('#id').focus();
		}else if ($pw  == '') {
			alert('비밀번호를 입력해 주세요.');
			$('#pw').focus();
		}else {
			console.log('서버에 전송');
			
			$.ajax({
				type:'post',
				url:'login',
				data:{'id':$id, 'pw':$pw},
				dataType:'JSON',
				success: function(data) {
					console.log(data);
					if (data.success>0) {
						alert(data.loginId+"님 환영합니다.");
						location.href='./list';
					}else{
						alert('아이디 또는 비밀번호를 확인하세요');
					}
				},
				error: function(e) {
					console.log(e);
				}
			});
		}
	});
</script>
</html>