<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); //post 방식으로 데이터를 전송했기 때문에 한글깨짐 방지 작업 필요
	//0. 파라메터 받기
	String id = request.getParameter("id"); //받은 request 객체에서 id 이름을 가진 파라메터를 꺼내 문자열 id 변수에 담음
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	
	System.out.println(id+"/"+pw+"/"+name+"/"+age+"/"+gender+"/"+email);
	
	Connection conn = null; //모든 영역에서 사용하기 때문에 커넥션을 전역 변수로 선언
	PreparedStatement ps = null; //위와 동일한 이유로 전역 변수로 선언
	try{
		//1. DB 접속
		Context ctx = new InitialContext(); //Context.xml 파일 안에 들어있는 DB 접근 정보를 자바에서 사용하기 위해서 객체화 
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB"); //Context 파일안에 이름이 jdbc/MariaDB 리소스를 꺼내와서 DataSource로 변환
		conn = ds.getConnection(); //그 데이터 소스로 커넥션 생성
		System.out.println(conn); 
		//2. 쿼리 실행
		String sql = "insert into member(id,pw,name,age,gender,email)values(?,?,?,?,?,?)"; //실행할 쿼리문을 준비
		ps = conn.prepareStatement(sql); //preparestatement 를 생성하고 실행할 쿼리를 지정
		ps.setString(1, id); //생성한 preparestatement의 set 메서드로 물음표에 대응하는 값을 정해줌
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setInt(4, Integer.parseInt(age));
		ps.setString(5, gender);
		ps.setString(6, email);
		
		//3. result.jsp 로 이동
		int result = ps.executeUpdate(); //preparestatement 을 실행하고 반환된 값으로
		if(result>0){ //실행이 성공하면
			response.sendRedirect("result.jsp"); //result.jsp로 이동
		}else{ //실행에 실패하면
			out.println("<h3>데이터 입력 실패</h3>"); //실패 문구를 출력
		}
	}catch(Exception e){ //try 구간에서 예외가 발생한다면
		e.printStackTrace(); //발생한 예외 정보 표시
		out.println("<h3>데이터 입력 실패</h3>"); //실패 문구 출력
	}finally{ //예외 발생 여부 상관 없이 무조건 실행
		conn.close(); //커넥션 반납
		ps.close(); //preparestatement 반납
	}	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>