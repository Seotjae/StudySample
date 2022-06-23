<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String loginId = (String)session.getAttribute("loginId");
	System.out.println("로그인 여부 : "+loginId);
	if(loginId == null){
		response.sendRedirect("index.jsp");
	}
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try{
		//2. DB 접속
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");
		conn = ds.getConnection();
		
		//3. 쿼리 실행
		String sql = "select id, name from member";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
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
	<h3>로그인 성공 <%=loginId%> 님 반갑습니다.</h3>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
	<br/>
	<table>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>상세보기</th>
			<th>삭제</th>
		</tr>
		<%while(rs.next()){%>
		<tr>
			<td><%=rs.getString("id") %></td>
			<td><%=rs.getString("name")%></td>
			<td><a href='detail.jsp?id=<%=rs.getString("id")%>'>상세보기</a></td>
			<td><a href='delete.jsp?id=<%=rs.getString("id")%>'>삭제</a></td>
		</tr>
		<%}%>
	</table>
</body>
</html>
<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		conn.close();
		ps.close();
		rs.close();
	}
%>
