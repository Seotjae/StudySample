<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		table, th, td{
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px 10px;
		}
		input[type='text']{
			background-color: lightgray;
			width: 110px;
		}

	</style>
</head>
<body>
	<h2>Team Project</h2>
	<hr>
	<table>
		<thead>
			<tr> 
				<th>팀</th>
				<th>프로젝트 명</th>
				<th>팀장</th>
				<th>팀원 1</th>
				<th>팀원 2</th>
				<th>팀원 3</th>
				<th>팀원 4</th>
				<th>팀원 5</th>
			</tr>
		</thead>
		<tbody id="list">
			
		</tbody>
	</table>
</body>
<script>
	list();

	function list() {
		$.ajax({
			url:'list',
			type:'get',
			data:{},
			dataType:'JSON',
			success: function(data) {
				console.log(data);
				drawList(data.list);
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
	
	function drawList(list) {
		var content = '';
		
		list.forEach(function(item,idx) { //하나씩 빼온 값, 인덱스 번호
			content += '<tr>';
			content += '<td>'+item.team_name+'</td>';
			content += '<td><input class="'+item.team_name+' project_name" type="text" value="'+item.project_name+'"/></td>';
			content += '<td><input class="'+item.team_name+' leader" type="text" value="'+item.leader+'"/></td>';
			content += '<td><input class="'+item.team_name+' staff1" type="text" value="'+item.staff1+'"/></td>';
			content += '<td><input class="'+item.team_name+' staff2" type="text" value="'+item.staff2+'"/></td>';
			content += '<td><input class="'+item.team_name+' staff3" type="text" value="'+item.staff3+'"/></td>';
			content += '<td><input class="'+item.team_name+' staff4" type="text" value="'+item.staff4+'"/></td>';
			content += '<td><input class="'+item.team_name+' staff5" type="text" value="'+item.staff5+'"/></td>';
			content += '</tr>';
		});
		
		
		$('#list').empty();
		$('#list').append(content);
		
		$('input[type="text"]').focusin(function(e) {
			$(this).css('background-color','white');
		});
		$('input[type="text"]').focusout(function(e) {
			$(this).css('background-color','lightgray');
			
			//1. 포커스 아웃을 하면 수정 요청
			//2. 변경된 내용이 있으면 수정 요청 (e를 이용해서 현재 값과 기본 값을 알아보기)
			if (e.currentTarget.defaultValue != e.currentTarget.value) {
				reqUpdate($(this)[0]); //js 객체로 사용할 수 있도록 배열에서 빼준다
			}
			
			
		});
		
	}
	
	function reqUpdate(elem) {
		console.log('수정 요청',elem.value);
		//특정 값을 수정하기 위해서는 무엇이 필요한가? (pk,컬럼,값)
		var val = elem.value; //값
		console.log(elem.classList);
		var col = elem.classList[1];//컬럼
		var pk = elem.classList[0];//pk
		console.log(col,val,pk);
		//update/{col}/{val}/{pk}
		$.ajax({
			url:'update/'+col+'/'+val+'/'+pk,
			type:'get',
			data:{},
			dataType:'JSON',
			success: function(data) {
				console.log(data);
			},
			error: function(e) {
				console.log(e);
			}
		});
		
		
	}
	
	

</script>
</html>