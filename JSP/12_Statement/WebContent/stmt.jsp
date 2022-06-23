<%@page import="java.sql.Statement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//db접속
	//1. Context.xml 을 객체로 만들기
	Context ctx = new InitialContext();
	
	//2. name 으로 Resource 찾아서 DataSource 로  변환하기
	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");
	
	//3. DataSource 로 Connection 생성하기
	Connection conn = ds.getConnection();
	if(conn != null){
		out.println("<h3>DB접속 완료</h3>");
	}
	
	try{
		//4. Connection 을 이용해서 쿼리 실행
		Statement stmt = conn.createStatement(); //4-1 Statement 객체를 connection 으로 부터 가져옴
		String sql = "create table member(" //4-2 쿼리 준비 
				+"ID varchar(50) primary key"
				+",PW varchar(100) not null"
				+",NAME varchar(50)"
				+",AGE int(3)"
				+",GENDER varchar(4)"
				+",EMAIL varchar(100)"
				+")"; //java 에서 쿼리문 작성시 세미콜론은 빼준다
		
		stmt.executeUpdate(sql); //4-3 쿼리 실행
		
		out.println("<h3>테이블 생성 성공</h3>");//4-4 성공여부 확인
		
		//5. 사용한 자원 닫아주기
		stmt.close();
		conn.close();
	}catch(Exception e){//Exception 이 나면 실패
		out.println("<h3>테이블 생성 실패</h3>");
	}
%>
