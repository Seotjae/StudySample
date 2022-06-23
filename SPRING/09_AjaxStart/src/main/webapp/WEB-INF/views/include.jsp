<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		table ,th,td{
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px 10px;
		}
		div.floating{
			width: 200px;
			height: 100px;
			text-align: center;
			border: 1px solid black;
			background-color: lightgray;
			position: absolute;
			top: 25%;
			left: 35%;
		}
	</style>
</head>
<body>
	<button id="popup1">1번 팝업</button>
	<button id="popup2">2번 팝업</button>
	<button id="popup3">3번 팝업</button>
	<div id="noticeArea"></div>
	<div id="listArea"></div>
</body>
<script>

	//버튼을 누르면 특정한 html 내의 특정한 요소가 나타나도록
	$('button').click(function(e) {
		console.log(e.target.id);
		//load() 라는 함수를 사용하면 다른 html 을 쉽게 불러올 수 있다
		//$('표현할 위치').load('불러올 위치 [id|class|tag]',callback);
		$('#noticeArea').load('resources/html/notice.html #'+e.target.id,
			function(res,stat){
				console.log(res); //해당 html 의 전체 소스가 담긴 매개 변수
				console.log(stat); //성공/실패 상태 정보가 담긴 매개변수
			
		});
		
	})




	//ajax 를 이용해 특정 html 을 불러오기
	$.ajax({
		type:'get',
		url:'resources/html/list.html',
		dataType:'html',
		success: function(data) {
			console.log(data);
			$('#listArea').html(data);
		},
		error: function(e){
			console.log(e);
		}
	});
	
	
	
	
</script>
</html>