<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.invalidate(); //세션을 완전히 지우고 다시 만든다, ID 가 바뀐다
	response.sendRedirect("index.jsp");
%>