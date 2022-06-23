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
		    	<input type="text" name="id"/>
		    	<input type="button" id="overlay" value="중복체크"/>
		    </td>
		  </tr>
		  <tr>
		    <th>PW</th>
		    <td><input type="password" name="pw"/></td>
		  </tr>
		  <tr>
		    <th>NAME</th>
		    <td><input type="text" name="name"/></td>
		  </tr>
		  <tr>
		    <th>AGE</th>
		    <td><input type="text" name="age"/></td>
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
		    <td><input type="text" name="email"/></td>
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

	//회원가입
	$("#regist").click(function() {
		console.log('click');
		if (check){
			console.log('회원가입 시작');
			var $id =$('input[name="id"]');
			var $pw =$('input[name="pw"]');
			var $name =$('input[name="name"]');
			var $age =$('input[name="age"]');
			var $gender =$('input[name="gender"]:checked');
			var $email =$('input[name="email"]');
			console.log($gender);
			
			if ($id.val() == '') {
				alert('아이디를 입력하세요.');
				$id.focus();
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
			}else { //모두 입력했을 경우
				console.log('서버전송 시작');
			
				var param = {'id':$id.val()}; //Object 에 데이터 넣는법 1. 직접 넣는 방법
				param.pw=$pw.val(); //Object 에 데이터 넣는법 2. 속성을 지정해서 넣는 법
				param['name']=$name.val(); //Object 에 데이터 넣는법 3. 배열 처럼 넣는 법
				param.age=$age.val();
				param.gender=$gender.val();
				param.email=$email.val();
				console.log(param);
			
			
				$.ajax({
					type:'post',
					url:'join',
					data:param,
					dataType:'JSON',
					success : function(data) {
						console.log(data);
						if (data.success == 1) {
							alert('회원가입을 축하 드립니다.');
							location.href='./';
						}else {
							alert('회원가입에 실패 했습니다. 다시 시도해 주세요.');
						}
					},
					error : function(e) {
						console.log(e);
						alert('서버에 문제가 발생 했습니다. 고객센터에 문의해 주세요.')
					}
				});
			}
				
		}else {
			alert('아이디 중복 체크를 해 주세요!');
			$('input[name="id"]').focus();
		}
	})
	
	

	//아이디 중복 체크
	$('#overlay').click(function() { //아이디가 오버레이인 버튼을 클릭 하면 다음의 함수를 실행
		console.log("중복체크 클릭"); //이벤트 작동 확인
		
		var id = $('input[name="id"]').val();  //id 변수에 name 이 id 인 input 태그의 value 를 넣는다
		console.log('check id : ',id); //원하는 데이터 확인 //id 의 값을 확인
		
		$.ajax({ //form 을 대신하여 비동기방식의 ajax를 사용
			type:'get', //get 방식으로
			url:'overlay', //overlay 요청을 보내고
			data: {'id':id}, //id라는 키의 id변수의 값을 
			dataType: 'json', //응답 받을 데이터 타입
			success: function(data) { //요청이 성공하면 다음의 함수를 실행 -> 응답 받은 map 을 data 라는 매개변수로 받음
				console.log(data); //요청 후 정상적인 응답 확인 //받은 응답을 확인
				
				if (data.overlay) { //받은 응답에서 overlay 라는 키의 값이 true (db 에 존재한다면)
					alert('이미 사용중인 아이디 입니다'); //아래의 내용 실행
					$('input[name="id"]').val('');
				}else{ //false 라면 아래의 내용 실행
					alert('사용 가능한 아이디 입니다');
					check=true;
				}
				
			},
			error: function(e) { //요청에 실패하면 다음의 함수를 실행
				console.log(e);
			}
		});	
	});




















</script>
</html>