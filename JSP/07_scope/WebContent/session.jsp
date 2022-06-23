<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//받아온 내용을 session 에 저장
String email = request.getParameter("email");
String phone = request.getParameter("cellphone");
session.setAttribute("email", email);
session.setAttribute("phone", phone);

//result.jsp 로 이동
response.sendRedirect("result.jsp");

%>
