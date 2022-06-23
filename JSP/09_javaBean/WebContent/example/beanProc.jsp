<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 빈 사용을 위해서 usebean 사용 -->
<jsp:useBean id="firstBean" class="com.beans.FirstBean" scope="session"/>

<%-- 하나의 스크립틀릿 전체를 주석
	String name = request.getParameter("userName"); //파라메터를 받아와서
	firstBean.setName(name); //빈에 넣는다
	response.sendRedirect("result.jsp"); //페이지 이동
--%>

<!-- 액션 태그로 대체 -->
<!-- name : 사용할 빈, property : 사용할 필드명, param : 대입할 파라메터의 이름 -->
<jsp:setProperty name="firstBean" property="name" param="userName"/>
<!-- action tag 에는 redirect 가 없다 -->
<jsp:forward page="result.jsp"/>
