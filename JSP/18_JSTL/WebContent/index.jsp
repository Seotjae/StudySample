<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL 태그 종류</h3>
	<ol>
		<li><a href="taglist/setTag.jsp">*c:set</a></li>
		<li><a href="taglist/ifTag.jsp">*c:if</a></li>
		<li>*c:choose
			<form action="taglist/chooseTag.jsp">
				<input type="text" name="num"/>
				<button>전송</button>
			</form>
		</li>
		<li><a href="taglist/forEachTag.jsp">*c:forEach</a></li>
		<li><a href="taglist/urlTag.jsp">*c:url</a></li>
		<li><a href="taglist/tokensTag.jsp">c:forTokens</a></li>
		<li><a href="taglist/importTag.jsp">c:import</a></li>
		<li><a href="taglist/redirectTag.jsp">c:redirect</a></li>
		<li><a href="taglist/functionTag.jsp">function tag</a></li>
		<li><a href="#">c:catch(개별학습)</a></li>
		<li><a href="#">c:out(개별학습)</a></li>
	</ol>
</body>
</html>