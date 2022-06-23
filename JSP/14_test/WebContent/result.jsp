<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
table, th, td{
border: 1px solid black;
border-collapse: collapse;
padding:5px;
}
</style>
<%
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try{
		//1. DB 접속
		Context ctx = new InitialContext(); //context 파일 객체화
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MariaDB"); //객체화된 파일에서 db 리소스를 가져와서 datasource로 변환
		conn = ds.getConnection(); //그 datasource로 커넥션을 생성
		
		//2. 쿼리 실행
		String sql = "select * from member"; //실행할 쿼리를 준비
		ps = conn.prepareStatement(sql); //준비한 쿼리를 실행할 스테이트먼트 생성
		rs = ps.executeQuery(); //스테이트먼트를 실행, 실행할 쿼리가 select문이기 때문에 executeQuery 사용, 이 메서드는 ResultSet을 반환한다
%>
	
<!-- HTML 영역 (table 시작) -->
<table>
	<tr>
		<th>ID</th><th>PW</th><th>NAME</th><th>AGE</th><th>GENDER</th><th>EMAIL</th>
	</tr>
<%		//3. 출력
		while(rs.next()){ //반환된 resultset의 next 메서드로 다음 값의 여부를 true/false 로 반환하기 때문에 while 반복문의 조건으로 사용
%>
	<tr>
	<td><%=rs.getString("id")%></td> <!--resultset 에서 컬럼이름이 id 인 값을 가져옴-->
	<td><%=rs.getString("pw")%></td> <!--resultset 에서 컬럼이름이 pw 인 값을 가져옴-->
	<td><%=rs.getString("name")%></td> <!-- 컬럼이름 대신 컬럼의 번호로 값을 가져올 수 있지만 소스만 보고 무슨 값을 가져오는지 확인하기 불편하기 때문에 비추천 -->
	<td><%=rs.getString("age")%></td>
	<td><%=rs.getString("gender")%></td>
	<td><%=rs.getString("email")%></td>
	</tr>
<%
		}

%>
</table>
<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{ //사용한 자원들 반납
		ps.close();
		conn.close();
		rs.close(); //resultset 도 반납해야 한다
	}
%>
