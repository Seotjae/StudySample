<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//세션 정보로 로그인 상태 확인
	String loginId = (String)session.getAttribute("loginId");
	if(loginId == null){
		response.sendRedirect("index.jsp");
	}
	
	//1. 파라메터 받기
	String id=request.getParameter("id");
	
	//2. DB접속
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
		
	try{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");
		conn = ds.getConnection();
		
		//3. 쿼리문 실행
		String sql = "select * from member where id=?";
		ps = conn.prepareStatement(sql); //스테이트먼트 생성
		ps.setString(1, id); //물음표 대응
		rs=ps.executeQuery(); //쿼리 실행
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%if(rs.next() == true){%>
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
	<button onclick="location.href='main.jsp'">뒤로가기</button>
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