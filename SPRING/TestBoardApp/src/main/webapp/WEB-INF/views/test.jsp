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
	<form id="form" action="check" method="post">
		<input type="radio" name="point" value="1000">1,000
		<input type="radio" name="point" value="5000">5,000
		<input type="radio" name="point" value="10000">10,000
		<button>결제하기</button>
	</form>
	
	<input type="text"/>
	<input type="text"/>
	<button onclick="confirm()">확인</button>
	<button onclick="alert()">확인</button>
	


	
</body>
<script>

</script>
</html>