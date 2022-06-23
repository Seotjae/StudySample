<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String sql1="insert into member values('tranx1','test','manager',40,'남','test@naver.com')";
String sql2="insert into member2 values('tranx2','test','manager',40,'남','test@naver.com')";

Connection conn = null;
PreparedStatement ps = null;

try{
	Context ctx = new InitialContext(); //1. Context.xml 객체화
	DataSource ds= (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB"); //2. lookup() 으로 Resource 불러와서 DataSource로 변환
	conn = ds.getConnection();	//3. Connection 생성
	
	conn.setAutoCommit(false);//autocommit OFF -> commit을 수동으로 변환
	
	//4. 쿼리 실행 (정상 쿼리)
	ps = conn.prepareStatement(sql1); //4-1 Statement 생성
	int success = ps.executeUpdate(); //4-2  실행
	System.out.println("쿼리 1번 실행 결과 : " + success); //4-3 결과
	ps.close();
	
	//4. 쿼리 실행 (비정상 쿼리)
	ps = conn.prepareStatement(sql2); //4-1 Statement 생성
	success = ps.executeUpdate(); //4-2  실행
	System.out.println("쿼리 2번 실행 결과 : " + success); //4-3 결과
	
	if(success>0){
		conn.commit(); //최종 승인
	}else{
		conn.rollback(); //전체 취소
	}
}catch(Exception e){
	e.printStackTrace();
	conn.rollback(); //예외 발생 시에도 rollback
}finally{
	//5. 자원반납
	ps.close();
	conn.close();
}

%>

