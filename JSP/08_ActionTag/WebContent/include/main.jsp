<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<!-- include 시 특정한 값을 전달 -->
	<jsp:include page="body.jsp">
		<jsp:param name="msg" value="my content"/>
	</jsp:include>
	
	<jsp:include page="footer.jsp"/>

</body>
</html>