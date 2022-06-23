<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//session 에서 msg 속성을 지우고
	session.removeAttribute("msg");
	//index.jsp 페이지로 보낸다
	response.sendRedirect("index.jsp");
%>