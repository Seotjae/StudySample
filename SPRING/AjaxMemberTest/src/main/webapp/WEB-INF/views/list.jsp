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
	
</body>
<script>
	//페이지 도착하자 마자 ajax 실행
	$.ajax({
		type:'get',
		url:'listCall',
		data:{},
		dataType:'JSON',
		success: function(data) {
			console.log(data);
		},
		error: function(e) {
			console.log(e);
		}
	});




</script>
</html>