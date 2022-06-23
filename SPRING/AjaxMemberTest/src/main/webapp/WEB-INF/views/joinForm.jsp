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
		    <td>
		    	<input type="text" id="id"/>
		    	<input type="button" id="overlay" value="중복확인"/>
		    </td>
		  </tr>
		  <tr>
		    <th>PW</th>
		    <td><input type="password" id="pw"/></td>
		  </tr>
		  <tr>
		    <th>NAME</th>
		    <td><input type="text" id="name"/></td>
		  </tr>
		  <tr>
		    <th>AGE</th>
		    <td><input type="text" id="age"/></td>
		  </tr>
		  <tr>
		    <th>GENDER</th>
		    <td>
		    	<input type="radio" name="gender" value="남"/>남 &nbsp;&nbsp;&nbsp;
		    	<input type="radio" name="gender" value="여"/>여
		    </td>
		  </tr>
		  <tr>
		    <th>EMAIL</th>
		    <td><input type="text" id="email"/></td>
		  </tr>
		  <tr>
		    <th colspan="2">
		    	<input type="button" id="regist" value="회원가입"/>
		    </th>
		  </tr>
	</table>
	
</body>
<script>

	var check = false;

	$('#regist').click(function(){
		console.log('회원가입 버튼 클릭');
		var $id = $('#id');
		var $pw = $('#pw');
		var $name = $('#name');
		var $age = $('#age');
		var $gender = $('input[name="gender"]:checked');
		var $email = $('#email');
		
		console.log($gender.val(),$pw.val());
		
		if (!check) {
			alert('중복확인을 해주세요.');
		}else if ($pw.val() == '') {
			alert('비밀번호를 입력하세요.');
			$pw.focus();
		}else if ($name.val() == '') {
			alert('이름을 입력하세요.');
			$name.focus();
		}else if ($age.val() == '') {
			alert('나이를 입력하세요.');
			$age.focus();
		}else if ($gender.val() == null) {
			alert('성별을 선택하세요.');
		}else if ($email.val() == '') {
			alert('이메일을 입력하세요.');
			$email.focus();
		}else {
			console.log('서버전송 시작');
			
			var params = {};
			params.id = $id.val();
			params.pw=$pw.val();
			params.name=$name.val();
			params.age=$age.val();
			params.gender=$gender.val();
			params.email=$email.val();
			console.log(params);
			
			$.ajax({
				type:'post',
				url:'regist',
				data:params,
				dataType:'JSON',
				success: function(data) {
					console.log(data.result);
					if (data.result>0) {
						alert('회원가입에 성공했습니다.');
						location.href='./';
					}else {
						alert('회원가입에 실패했습니다.');
					}
				},
				error: function(e) {
					console.log(e);
				}
			});
			
			
		}
		
	});







	$('#overlay').click(function(){
		console.log('중복확인 버튼 클릭 : '+$('#id').val());
		if ($('#id').val() == '') {
			alert('아이디를 입력하세요.');
			$('#id').focus();
		}else{
						$.ajax({
				type:'get',
				url:'overlay',
				data:{'id':$('#id').val()},
				dataType:'JSON',
				success: function(data) {
					console.log(data.result);
					if (data.result>0) {
						alert('이미 사용중인 아이디 입니다.');
						$('#id').focus();
						$('#id').val('');
					}else {
						alert('사용 가능한 아이디입니다.');
						check = true;
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