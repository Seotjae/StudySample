<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.removeAttribute("loginId"); //세션에 저장된 loginId 속성과  그 속성 값을 지운다
	response.sendRedirect("login.jsp"); //login.jsp 페이지로 이동시킨다
%>
