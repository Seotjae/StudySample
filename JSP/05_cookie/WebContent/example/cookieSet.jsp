<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//받은 데이터를 통해
	String param = request.getParameter("lang");
	System.out.println("param : "+param);
	
	//쿠키를 생성
	Cookie cookie = new Cookie("lang",param); //name 과 value 를 넣어서 쿠키 생성
	cookie.setMaxAge(60*60*24); //수명 (초 단위) 지정
	response.addCookie(cookie); //쿠키를 client에 저장
	response.sendRedirect("cookieGet.jsp");//그리고 결과 페이지로 이동

%>