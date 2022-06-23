<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 변수 및 메서드 선언 -->
<%!
	Calendar c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);


%>
    
<div class="header">
	
	현재 시간은 <%=hour%>시 <%=minute%>분 <%=second%>초 <!-- 출력 -->
	
	<%if(hour>=12){%> <!-- 자바 로직 -->
	오후 입니다.
	<%}else{%>
	오전 입니다.
	<%}%>

</div>