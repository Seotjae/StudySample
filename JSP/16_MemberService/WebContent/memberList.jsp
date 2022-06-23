<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String loginId = (String)session.getAttribute("loginId");
	if(loginId == null){
		response.sendRedirect("index.jsp");
	}

	Context ctx = new InitialContext();
	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");
	Connection conn = ds.getConnection();
	
	String sql = "select id, name from member";
	PreparedStatement ps = conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	System.out.println("rs : "+rs);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td{
		border: 1px solid black;
		border-collapse: collapse;
		padding: 5px;
	}
</style>
</head>
<body>
	<h2>회원 리스트</h2>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>상세보기</th>
			<th>삭제</th>
		</tr>
		<%while(rs.next()){%>
		<tr>
			<!--id 는 여기서 컬럼이름-->
			<td><%=rs.getString("id") %></td>
			<td><%=rs.getString("name")%></td>
			<!--?을 통해 파라메터를 전달하는 방식은 form 의 get 과 같은 방식이다-->
			<td><a href='detail.jsp?id=<%=rs.getString("id")%>'>상세보기</a></td>
			<td><a href='delete.jsp?id=<%=rs.getString("id")%>'>삭제</a></td>
		</tr>
		<%}%>
	</table>
</body>
</html>