<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String loginId = (String)session.getAttribute("loginId");
	if(loginId == null){
		response.sendRedirect("index.jsp");
	}
	//1. memberList.jsp 에서 id를 받아와 System.out 으로 찍기
	String id=request.getParameter("id");
	System.out.println(id);
	
	//2. DB접속 시키기
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	try{
	Context ctx = new InitialContext();
	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");
	conn = ds.getConnection();
	
	//3. 쿼리문 실행
	String sql = "select * from member where id=?";
	ps = conn.prepareStatement(sql);
	ps.setString(1, id);
	rs=ps.executeQuery();
	
	//4. 받아온 ResultSet 값 System.out 으로 찍기
	System.out.println(rs);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td, th{
		border:1px solid black;
		border-collapse: collapse;
		padding: 5px;
	}
</style>
</head>
<body>
	<table>
		<%if(rs.next() == true){ //만약 rs에 값이 있다면 -> rs.next() 하지 않으면 값 자체를 꺼낸 상태가 아니다%>
		<tr>
			<th>ID</th><td><%=rs.getString("id")%></td>
		</tr>
		<tr>
			<th>PW</th><td><%=rs.getString("pw")%></td>
		</tr>
		<tr>
			<th>NAME</th><td><%=rs.getString("name")%></td>
		</tr>
		<tr>
			<th>AGE</th><td><%=rs.getString("age")%></td>
		</tr>
		<tr>
			<th>GENDER</th><td><%=rs.getString("gender")%></td>
		</tr>
		<tr>
			<th>EMAIL</th><td><%=rs.getString("email")%></td>
		</tr>
		<%}else{%>
		<tr>
			<td colspan="2">요청하신 id를 가진 회원이 없습니다.</td>
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