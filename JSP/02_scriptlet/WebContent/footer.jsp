<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//변수 선언
	String title = "1 부터 100 까지 합 구하기";
	
	//메서드 선언
	public int whileSum(){
		int total = 0;
		
		for(int i=0; i<=100; i++){
			total += i;	
		}
		return total;
	}
%>
<div>
	<p><%=title %></p>
	<p>답은 <%=whileSum()%> 입니다.</p>
</div>