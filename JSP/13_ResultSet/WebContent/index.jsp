<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//db 접속 준비
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//1. Context.xml 을 객체화 하기
	Context ctx = new InitialContext();
	//2. Dataresource 객체화
	DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MariaDB");
	
	try{
		//3. DataSource 를 통해서 Connection 가져오기
		conn = ds.getConnection();
		
		//4. 쿼리문 실행
		String sql = "select * from member"; //4-1 쿼리문 준비
		ps = conn.prepareStatement(sql); //4-2 PrepareStatement 가져오기
		//4-3 물음표(?) 대응 (쿼리문에 물음표 없어서 생략)
		rs = ps.executeQuery(); //4-4 실행
		//4-5 결과에 따른 처리
		//System.out.print(rs.getMetaData().getColumnCount());
		while(rs.next()){ //값을 꺼내옴 (다음 값이 있는지 확인 true/false)
			String id = rs.getString("id"); //get[Type](컬럼명)
			String pw = rs.getString("pw");
			String name = rs.getString(3); //get[Type](컬럼순서) -> 비추천, 소스만 봐서는 파악이 어렵다
			String age = rs.getString("age");
			String gender = rs.getString("gender");
			String email = rs.getString("email");
			out.println("<p>"+id+"/"+pw+"/"+name+"/"+age+"/"+gender+"/"+email+"</p>");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{//5. 자원반납
		ps.close();
		conn.close();
		rs.close();
	}
	
%>
