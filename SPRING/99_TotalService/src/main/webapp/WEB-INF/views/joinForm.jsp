<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		table, th, td{
			border : 1px solid black;
			border-collapse: collapse;
			padding: 5px;
		}	
	</style>
</head>
<body>
	<form id="joinForm" action="join" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id"/>
					<input id="overlay" type="button" value="중복체크"/>
					<p id="overlay_msg"></p>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input id="pass" type="text" name="pw"/></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input id="pass_confirm" type="text"/>
					<p id="pw_confirm"></p>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"/></td>
			</tr>
						<tr>
				<th>나이</th>
				<td><input type="text" name="age"/></td>
			</tr>
						<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="남"/> 남자
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" value="여"/> 여자
				</td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="email" name="email"/></td>
			</tr>
			<tr>
				<th colspan="2">
					<input id="member_join" type="button" value="회원가입"/>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
	var overlayChk = false;
	$('#overlay').on('click', function() {
		console.log('클릭');
		var chkId = $('input[name="id"]').val();
		console.log(chkId);
		$.ajax({
			url:'overlay',
			type:'get',
			data:{id:chkId},
			dataType:'JSON',
			success: function(data) {
				var msg = '';
				if (data.overlay) {
					msg='사용 중인 아이디 입니다.';
					$('input[name="id"]').val('');
				}else{
					msg='사용 가능한 아이디 입니다.';
					overlayChk = true;
					
				}
				$('#overlay_msg').html(msg);
			},
			error: function(e) {
				console.log(e);
			}
		});
	});
	
	$('#pass_confirm').keyup(function() {
		var pass = $('#pass').val();
		var confirm = $('#pass_confirm').val();
		console.log(pass,confirm);
		var msg = '';
		if(pass === confirm){
			msg = '비밀번호가 일치합니다.';
		}else{
			msg = '비밀번호가 일치하지 않습니다.';
		}
		$('#pw_confirm').html(msg);
	});
	
	$('#member_join').click(function() {
		if (overlayChk) {
			$('#joinForm').submit();
		}else {
			alert('아이디 중복체크를 해주세요.');
		}
	});
</script>
</html>




