<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td {
		border : 1px solid black;
		border-collapse: collapse;
		padding: 10px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td>이름</td>
			<td id='name'></td>
		</tr>
		<tr>
			<td>성별</td>
			<td id='gender'></td>
		</tr>			
		<tr>
			<td>취미</td>
			<td id='hobby'></td>
		</tr>	
	</table>
</body>
<script>
	var name = '<%=request.getParameter("userName")%>';
	var gender = '<%=request.getParameter("gender")%>';
	console.log(name+'/'+gender);
	var hobby = [];
	<%
		String[] hobbys = request.getParameterValues("hobby");
		for(String hobby:hobbys){
	%>
		hobby.push('<%=hobby%>');
	<%	
		}
	%>
	console.log(hobby);
	
	document.getElementById('name').innerHTML = name;
	document.getElementById('gender').innerHTML = gender;
	document.getElementById('hobby').innerHTML = hobby.join(',');

</script>
</html>