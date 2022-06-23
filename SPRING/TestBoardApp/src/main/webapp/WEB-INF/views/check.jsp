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
${point}
<button onclick="pay()">결제하기</button>
	
</body>
<script>
 var $val  = ${point}
 function pay() {
	location.href='pay?val='$val;
}
</script>
</html>