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
	//1. 파라메터 받아오기
	String id = request.getParameter("id");
	System.out.println(id);
	
	//2. DB 접속
	Connection conn = null;
	PreparedStatement ps = null;
	int success = 0;
	try{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");
		conn = ds.getConnection();		

	//3. 받아온 아이디로 데이터 지우는 쿼리 실행
		String sql = "delete from member where id=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		success = ps.executeUpdate();	
	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
		//4. 결과 확인 (성공과 실패에 따라 메시지를 달리보여주고 main.jsp로 보낸다)
		out.print("<script>");
		if(success>0){
			out.println("alert('삭제에 성공 했습니다.')");
		}else{
			out.println("alert('삭제에 실패 했습니다.')");
		}
		out.print("location.href='main.jsp'");
		out.print("</script>");
		
		//5. 자원반납
		conn.close();
		ps.close();
	}
%>