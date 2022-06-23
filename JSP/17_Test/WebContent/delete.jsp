<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//세션 정보로 로그인 상태 확인
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
	int result = 0;
	try{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");
		conn = ds.getConnection();		

		//3. 받아온 아이디로 데이터 지우는 쿼리 실행
		String sql = "delete from member where id=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		result = ps.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		//4. 결과 확인 
		out.print("<script>");
		if(result>0){ //결과가 성공이면
			out.println("alert('삭제에 성공 했습니다.')");
		}else{ //실패면
			out.println("alert('삭제에 실패 했습니다.')");
		}
		out.print("location.href='main.jsp'"); //성공실패 상관없이 이동
		out.print("</script>");
		
		//5. 자원반납
		conn.close();
		ps.close();
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