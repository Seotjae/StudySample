<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//1. 접속 정보를 확보 (아이디, 비밀번호, DB 접속 주소)
	String id = "web_user"; //db 유저 id
	String pw = "pass"; //db 유저 pw
	String url = "jdbc:mariadb://localhost:3306/gdj42_csj"; //db 주소 -> jdbc:mariadb://IP주소:PORT번호/데이터베이스이름
	String driver = "org.mariadb.jdbc.Driver"; //1-1. 접속에 사용될 클래스 드라이버 (mariadb class driver 라고 검색할 것)
	
	//2. 드라이버 매니저를 통해 커넥션 요청
	Class.forName(driver); //위의 드라이버를 사용해서
	Connection conn = DriverManager.getConnection(url,id,pw); //드라이버 매니저에게 요청
	
	//3. 커넥션이 있으면 접속 성공
	if(conn != null){
		System.out.println("connection success");
	}else{
		System.out.println("connection fail");
	}
	
	//4. 커넥션을 가지고 데이터 베이스를 마음대로 다룬다 (현재 우리 단계에서는 생략)
	
	//5. 사용을 다 하면 커넥션을 닫아준다 (반납) -> 중요
	conn.close();
	
	//이것보다 간소화된 방법을 사용한다 -> 위의 정보들이 다 사용되긴 함
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