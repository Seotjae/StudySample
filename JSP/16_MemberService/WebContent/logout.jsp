<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//로그아웃 : 세션에서 loginId 속성을 제거하는 것
	session.removeAttribute("loginId");
	response.sendRedirect("index.jsp");
%>
