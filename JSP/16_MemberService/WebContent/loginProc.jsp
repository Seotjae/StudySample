<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//1. 파라메터 추출
	String id = request.getParameter("userId");
	String pw = request.getParameter("userPass");
	//System.out.println(id+"/"+pw);
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String location = "index.jsp"; //기본 값은 실패 했을 때 갈 페이지 지정
try{
	//2. 디비접속
	Context ctx = new InitialContext(); //Context.xml 파일 객체화
	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB"); //name 이 jdbc/MariaDB 인 Source 찾아서 DataSource로 변환
	conn = ds.getConnection(); //DataSource 에서 Connection 생성
	//System.out.println(conn);
	
	//3. 쿼리실행
	String sql ="select id from member where id=? and pw=?"; //실행할 쿼리 준비
	ps = conn.prepareStatement(sql); //PreparedStatement 생성
	ps.setString(1, id); //물음표 대응
	ps.setString(2, pw);
	rs = ps.executeQuery(); //쿼리 실행
	boolean exist = rs.next();
	System.out.println(id+" 가 있는지 여부 : " + exist);
	if(exist == true){ //로그인 성공
		location="main.jsp"; //성공시 location 경로 변경
		session.setAttribute("loginId", id); //session 에 로그인 했다는 증거를 남겨준다, loginId 속성 값이 null 이면 로그인 안한 것
	}
	
}catch(Exception e){
	e.printStackTrace();
		
}finally{
	conn.close();
	ps.close();
	rs.close();
	//4. 결과에 따른 페이지 이동
	response.sendRedirect(location);
}

%>
