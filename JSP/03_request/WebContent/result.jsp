<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//post 방식으로 한글을 보낼 때는 따로 한글깨짐 방지 처리를 해줘야 한다
	request.setCharacterEncoding("UTF-8");
%>

<%
	//다른 페이지에서 넘어오는 값을 받을 때는 request 객체를 사용한다
	String name = request.getParameter("userName"); //input 에 있는 name 은 반드시 복사해서 붙여넣기 해야 실수가 줄어듬
	String gender = request.getParameter("gender"); //request 는 내장 객체이기 때문에 객체화를 하지 않았다
	System.out.println(name+" / "+gender);
	
	//하나의 name 으로 여러 개의 값이 올 경우 (getParameter 사용하면 안됨)
	String[] hobbys = request.getParameterValues("hobby");
	for(String hobby:hobbys){
		System.out.println(hobby);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td {
		border : 1px solid black;
		border-collapse: collapse;
		padding: 10px;
	}
</style>
</head>
<body>
	<table>
			<tr>
				<td>이름</td>
				<td><%=name%></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><%=gender%></td>
			</tr>			
			<tr>
				<td>취미</td>
				<td>
				<% for(String hobby:hobbys){%>
					<%=hobby%>, 
				<%}%>				
				</td>
			</tr>	
		</table>
</body>
</html>