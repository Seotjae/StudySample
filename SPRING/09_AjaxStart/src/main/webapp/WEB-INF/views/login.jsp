<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
	</style>
</head>
<body>
	<!-- 동기 방식은 전송하고 나면 기존 페이지가 날라간다 -->
	<form action="login" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" id="userId" name="id" value=""/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" id="userPw" name="pw" value=""/></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" id="login" value="LOGIN"/>
				</th>
			</tr>
			
		</table>
	</form>


</body>
<script>
	/* ajax 사용시 submit 을 사용하지 않는다. form 도 사용하지 않는다. */
	//$.ajax() 를 사용하려면 반드시 jquery 가 있어야 한다
	$("#login").click(function() {
		//console.log('click');
		
		/* AJAX 의 기본 형태 
		$.ajax({ //무조건 이렇게 시작
			type:'', //method
			url:'', //action
			data:{}, //parameter
			dataType:'JSON' //JSON,XML,TEXT,HTML,JSONP
			success: function(data){}, //성공했을 때 해야할 일 (성공했을 때 서버에서 보낸 데이터를 매개변수로 받는다)
			error: function(e){} //에러났을 때 해야할 일 (에러 났을 때 서버에서 보낸 데이터를 매개변수로 받는다)
		}); */
				
		
		// ajax (비동기 방식) 은 기존 페이지를 그대로 유지한다
		//그렇기 때문에 서버 통신 시 문제가 발생해도 개발자 모드를 켜지 않으면 알 수 없다
		$.ajax({ 
			type:'post', 
			url:'login', 
			data:{
				id: $('#userId').val(),
				pw: $('#userPw').val()
			}, 
			dataType:'JSON', 
			success: function(data){
				console.log(data);
				alert(data.msg);
				location.href='include';
			}, 
			error: function(e){
				console.log(e);
				alert('ajax 실행 중 에러 발생');
			}
		}); 	
	});






</script>
</html>