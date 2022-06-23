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

	<form action="search" method="get">
		<fieldset>
			<select name="opt">
				<option value="id">아이디</option>
				<option value="name">이름</option>
				<option value="email">이메일</option>
			</select>
			<input type="text" name="keyword" placeholder="검색어를 입력하세요"/>
			<button>검색</button>
		</fieldset>
	</form>


	<button onclick="location.href='./logout'">로그아웃</button>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
			<th>이메일</th>
		</tr>
		<c:if test="${list.size() == 0}">
			<tr>
				<th colspan="6">회원이 없습니다.</th>
			</tr>
		</c:if>
		<c:if test="${list.size() > 0}">
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.id}</td>
					<td>${list.pw}</td>
					<td>${list.name}</td>
					<td>${list.age}</td>
					<td>${list.gender}</td>
					<td>${list.email}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	
	<!-- 항목의 갯수가 n개 일 경우... (찾는 이름이 1개일수도 있고 여러개일수도 있고) -->
	<fieldset>
		<form action="multi" method="post">
			<p>
				 이름이 <input type="text" name = "name"/> 이거나
				 <input type="text" name = "name"/> 인 회원 찾기
				<button>찾기</button>
			</p>
		</form>
	</fieldset>
	
	
	<!-- 값이 입력된 내용에 대해서만 수정 -->
	<fieldset>
		<form action="update" method="post">
			<p>수정할 ID : <input type="text" name="id"/></p>
			<p>수정할 PW : <input type="text" name="pw"/></p>
			<p>수정할 NAME : <input type="text" name="name"/></p>
			<p>수정할 AGE : <input type="text" name="age"/></p>
			<p>수정할 GENDER : <input type="text" name="gender"/></p>
			<p>수정할 EMAIL : <input type="text" name="email"/></p>
			<button>수정 요청</button>
		</form>
	</fieldset>
	
</body>
<script>
</script>
</html>