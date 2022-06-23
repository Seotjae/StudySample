<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//1. context.xml 을 자바 객체로 변환
	Context ctx = new InitialContext();

	//2. name 값으로 Resource 를 찾아서 DataSource 로 변환
	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");
	
	//3. 커넥션 생성 (커넥션이 있으면 접속 성공)
	Connection conn = ds.getConnection();
	System.out.println(conn);
	
	//4. 할일 한다 (생략)
	
	//5. 종료, 커넥션 반납
	conn.close();
%>