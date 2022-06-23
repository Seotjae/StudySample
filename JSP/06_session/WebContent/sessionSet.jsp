<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//세션을 저장하여
	session.setAttribute("msg", "new message"); //String, Object
	//세션 수명 설정 : cookie 와 다르다, 움직이지 않고 가만히 있을 때 유지되는 시간 - 기본 30분
	session.setMaxInactiveInterval(60); //초 단위
	//특정 페이지로 이동
	response.sendRedirect("index.jsp");

%>