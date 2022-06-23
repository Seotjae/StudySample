<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//1. 파라메터 받아오기
	String id = request.getParameter("userId");
	String pw = request.getParameter("userPass");
	String name = request.getParameter("userName");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	System.out.println(id+"/"+pw+"/"+name+"/"+age+"/"+gender+"/"+email);
	
	//2. DB 접속
	Connection conn = null;
	PreparedStatement ps = null;
try{
	Context ctx = new InitialContext(); //context.xml 객체화
	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB"); //name 에 맞는 Resource 찾아서 DataSource 로 변환
	conn = ds.getConnection(); //DataSource 에서 Connection 생성
	System.out.println(conn);
	
	//3. 쿼리 실행
	String sql = "INSERT INTO member(id,pw,name,age,gender,email)VALUES(?,?,?,?,?,?)"; //실행할 쿼리 준비 
	ps = conn.prepareStatement(sql); //prepareStatement 생성 -> 재사용을 위해 가지고 있으라고 변수에 넣어줌
	ps.setString(1, id); //물음표 대응
	ps.setString(2, pw);
	ps.setString(3, name);
	ps.setString(4, age);
	ps.setString(5, gender);
	ps.setString(6, email);
	int success= ps.executeUpdate(); //쿼리 실행
	
	//4. 결과에 따른 페이지 분기
	if(success > 0){
		conn.commit();
		out.println("<script>");
		out.println("alert('가입에 성공 했습니다.')");
		out.println("location.href='index.jsp'");
		out.println("</script>");
		
	}else{
		out.println("<script>");
		out.println("alert('가입에 실패 했습니다.')");
		out.println("location.href='joinForm.jsp'");
		out.println("</script>");
}
	
	
}catch(Exception e){
	e.printStackTrace();
	out.println("<script>");
	out.println("alert('가입에 실패 했습니다.')");
	out.println("location.href='joinForm.jsp'");
	out.println("</script>");
}finally{
	//5. 자원 반납
	ps.close();
	conn.close();
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