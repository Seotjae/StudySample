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
		<form action="join">
			암호화 : <input type="text" name="pass" value=""/>
			<button>JOIN</button>
		</form>

		<form action="confirm">
			확인 : <input type="text" name="pass" value=""/>
			<button>CONFIRM</button>
		</form>

	
</body>
<script>
	var msg = "${msg}";
	if (msg !="") {
		alert(msg);
	}
</script>
</html>