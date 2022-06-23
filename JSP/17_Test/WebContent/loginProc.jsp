<%@page import="java.sql.ResultSet"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//1. 로그인의 파라메터 받아오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pass");
	System.out.println(id+"/"+pw);

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try{
		//2. DB 접속
		Context ctx = new InitialContext();//context 파일 객체화
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");//Resource를 DataSource로 변환
		conn = ds.getConnection();//Connection 생성
		
		//3. 쿼리 실행 -> 파라메터와 DB 비교
		String sql = "select id from member where id=? and pw=?";//쿼리 실행
		ps = conn.prepareStatement(sql); //Preparestatement 생성
		ps.setString(1, id);//물음표 대응
		ps.setString(2, pw);
		rs = ps.executeQuery();//쿼리 실행

		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
		//4. 결과 처리 -> 로그인 성공 실패
		out.print("<script>");
		if(rs.next() == true){
			out.println("alert('로그인 성공.')");
			session.setAttribute("loginId", id);
			out.print("location.href='main.jsp'");
		}else{
			out.println("alert('로그인 실패.')");
			out.print("location.href='index.jsp'");
		}
		out.print("</script>");		
		
		//5. 자원반납
		conn.close();
		ps.close();
		rs.close();
	}
		
%>
