<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- el태그에서는 간단한 연산이 가능 (사칙연산 뿐 아니라, 논리연산도 가능하다)-->
	<!-- \는 escape 문자로 뒤에 있는 내용은 단순 문자로 취급된다 -->
	<ul>
		<!-- 사칙연산 -->
		<li>\${5+7} => ${5+7}</li>
		<li>\${8-3} => ${8-3}</li>
		<li>\${6*3} => ${6*3}</li>
		<li>\${9/3} => ${9/3}</li>
		<li>\${9%2} => ${9%2}</li>
		
		<!-- 논리연산 -->
		<li>\${10 == 9} => ${10 == 9}</li>
		<li>\${5 != 7} => ${5 != 7}</li>
		<li>\${3 < 8} => ${3 < 8}</li>
		<li>\${8 > 8} => ${8 > 8}</li>
		
		<!-- 3항연산 -->
		<li>\${5+3 == 8?1:0} => ${5+3 == 8?1:0}</li>
	</ul>
</body>
</html>