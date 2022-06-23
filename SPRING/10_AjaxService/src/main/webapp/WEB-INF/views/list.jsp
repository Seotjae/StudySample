<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<link rel="stylesheet" href="resources/css/common.css" type="text/css">
	<style>
	</style>
</head>
<body>
	<h3>게시판</h3>
	<button onclick="del()">삭제</button>
	<table>
		<thead>
			<tr>
		    	<th><input type="checkbox" id="all"/></th>
		    	<th>글번호</th>
		    	<th>제목</th>
		    	<th>조회수</th>  
		  	</tr>
		</thead>
		<tbody></tbody>
	</table>
</body>
<script>
	//리스트 불러오기 함수 호출
	listCall();
	
	$('#all').click(function() {
		var $chk = $('input[type="checkbox"]');
		//onsole.log($chk);
		console.log($(this).is(':checked'));
		if ($(this).is(':checked')) {
			$chk.attr('checked',true);
		}else {
			$chk.attr('checked',false);
		}
	});
	
	
	var delList = [];
	
	function del() {
		$('input[type="checkbox"]:checked').each(function(idx,item) {
			//console.log(idx,$(this).val());
			//delList[idx] = $(this).val();
			delList.push($(this).val());
		});
		console.log(delList);
		
		$.ajax({
			type:'get',
			url:'delete',
			data:{'delList':delList},
			dataType:'JSON',
			success: function(data) {
				console.log(data);
				alert(data.msg);
				//ajax 는 페이지를 새로고침 하지 않기 때문에, 적용된 내용을 확인하기 위해서 리스트를 다시 그려야한다
				//리스트 불러오기 함수 호출
				listCall();
				delList = [];
			},
			error: function(e) {
				console.log(e);
			}
		});	
	}

	
	function listCall() {
		//페이지 도착하자 마자 ajax 실행
		$.ajax({
			type:'get',
			url:'listCall',
			data:{},
			dataType:'JSON',
			success: function(data) {
				//console.log(data.list);
				listDraw(data.list);
			},
			error: function(e) {
				console.log(e);
			}
		});	
	}


	function listDraw(list) { //배열 안에 있는 내용을 표로 그리는 함수
		var content = "";
	
		for (var i = 0; i < list.length; i++) {
			//console.log(list[i]);
			content += '<tr>';
			content += '<td><input type="checkbox" name="del" value="'+list[i].idx+'"/></td>';
			content += '<td>'+list[i].idx+'</td>';
			content += '<td><a href="detail?idx='+list[i].idx+'">'+list[i].subject+'</a></td>';
			content += '<td>'+list[i].bHit+'</td>';
			content += '</tr>';
		}
		$('tbody').empty();
		$('tbody').append(content);
	}



</script>
</html>