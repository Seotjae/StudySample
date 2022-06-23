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
	<button onclick="oldAjax()">기존 ajax 방식</button>
	<button onclick="restful(3)">rest 방식</button>
	
	<p>ajax 응답은 반드시 HashMap 으로만 하는 것은 아니다.</p>
	<ul>
		<li>HashMap 형태로 반환 (가장 일반적인 방법) </li>
		<li>ArrayList 형태로 반환 <button onclick="sendAjax('list')">LIST</button></li>
		<li>DTO 형태로 반환 <button onclick="sendAjax('dto')">DTO</button></li>
	</ul>
		
</body>
<script>

	function sendAjax(type) {
		$.ajax({
			type:'get',
			url:'rest/'+type,
			dataType:'JSON',
			success: function(result) {
				console.log(result);
			},
			error: function(e) {
				console.log(e);
			}	
		});
	}

	
	function restful(no) {
		$.ajax({
			type:'get',
			url:'rest/getNo/'+no,
			dataType:'JSON',
			success: function(result) {
				console.log(result);
			},
			error: function(e) {
				console.log(e);
			}
		});
	}





	//id=1 을 보내면 답변을 {send:1,msg:'OK'} 가 나오도록
	function oldAjax() {
		$.ajax({
			type:'get',
			url:'testAjax',
			data:{'id':1},
			dataType:'JSON',
			success: function(result) {
				console.log(result);
			},
			error: function(e) {
				console.log(e);
			}
		});
	}


</script>
</html>