<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/common.css" type="text/css">
	<script src="resources/js/jquery.twbsPagination.js"></script>
	<style>
	</style>
</head>
<body>
	<h3>게시판</h3>
	<button onclick="more()">더보기</button>
	<table>
		<thead>
			<tr>
		    	<th>글번호</th>
		    	<th>제목</th>
		    	<th>조회수</th>  
		  	</tr>
		</thead>
		<tbody id="list"></tbody>
		<tr>
			<td colspan="3" id="paging">
				<div class="container">                           
               		<nav aria-label="Page navigation" style="text-align:center">
                  		<ul class="pagination" id="pagination"></ul>
               		</nav>               
            	</div>
			</td>
		</tr>
	</table>
</body>
<script>
	var currPage = 1;
	var totalPage = 2;
	
	listCall(currPage,10);
	
	function more() {
		currPage++;
		console.log('currPage',currPage);
		if (currPage > totalPage) {
			$('button').attr('disabled',true);
		}else {
			listCall(currPage,10);
			
		}
	}

	function listCall(no, cnt) {
		
		$.ajax({
			type:'get',
			url: 'list',
			data: {'page':no,'cnt':cnt},
			dataType: 'JSON',
			success: function(data) {
				console.log(data);
				totalPage = data.pages;
				listDraw(data.list);
				
				$('#pagination').twbsPagination({
					startPage:currPage, //현재 페이지
					totalPages:totalPage, //만들 수 있는 총 페이지
					visiblePages:5, //숫자 버튼 몇 개까지 보여줄 것인가
					onPageClick: function(evt,page) { //해당 페이지 번호를 클릭했을 때 일어날 일들
						console.log(evt); //현재 일어나는 클릭 이벤트 관련 정보들
						console.log(page); //몇 페이지를 클릭 했는지에 대한 정보
						listCall(page,10);
					}
				});
			},
			error: function(e) {
				console.log(e);
			}
		});
	}

	function listDraw(list) {
		var content = '';
		list.forEach(function(item,idx) {
			content += '<tr>'
			content += '<td>'+item.idx+'</td>'
			content += '<td>'+item.subject+'</td>'
			content += '<td>'+item.bHit+'</td>'
			content += '</tr>'
		});
		$('#list').empty();
		$('#list').append(content);
	}



</script>
</html>