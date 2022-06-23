<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
	//1. 회원가입의 파라메터 받아오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pass");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	System.out.println(id+"/"+pw+"/"+name+"/"+age+"/"+gender+"/"+email);
	
	//2. DB 접속
	Connection conn = null;
	PreparedStatement ps = null;
	int result = 0;
	try{
		Context ctx = new InitialContext(); //컨텍스트 파일 객체화
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB"); //Resource를 DataSource로 변환
		conn = ds.getConnection(); //커넥션 생성
		System.out.println(conn);
		
		//3. 쿼리 실행 -> 받아온 파라메터 DB에 입력
		String sql = "insert into member(id,pw,name,age,gender,email)values(?,?,?,?,?,?)";//쿼리 준비
		ps = conn.prepareStatement(sql); //PreparedStatement 생성
		System.out.println(ps);
		ps.setString(1, id);//쿼리의 물음표 대응
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setString(4, age);
		ps.setString(5, gender);
		ps.setString(6, email);
		result = ps.executeUpdate(); //쿼리 실행
		System.out.println(result); 
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		//4. 결과 처리 -> 회원가입 성공 실패 
		out.print("<script>");
		if(result>0){
			out.println("alert('회원가입 성공.')");
			out.print("location.href='index.jsp'");
		}else{
			out.println("alert('회원가입 실패.')");
			out.print("location.href='joinForm.jsp'");
		}
		out.print("</script>");
		
		//5. 자원반납
		conn.close();
		ps.close();
	}
	
	
	
	
	
%>