<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String msg = request.getParameter("msg");
%>
<div>
	<h1>BODY PAGE</h1>
	<h3><%=msg%></h3>
	<hr/>
</div>