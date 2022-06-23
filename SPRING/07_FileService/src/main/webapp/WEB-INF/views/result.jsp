<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style></style>
</head>
<body>
<%-- 
	<c:if test="${list eq null}">업로드 된 이미지가 없습니다.</c:if>
	<c:if test="${list ne null }">
		<c:forEach items="${list}" var="path">
			<img width="500" src="/photoFile/${path}"/>
			<a href="delete?file=${path}">삭제</a>
			<br/>
		</c:forEach>	
	</c:if>
--%>
	
	<div id="area"></div>
	
	<a href="./">돌아가기</a>
</body>
<script>
	var files=[]; //컨트롤러에서 받은 list 들을 담을 배열
	
	<c:forEach items="${list}" var="path"> //컨트롤러에서 보낸 list 를 path 에 담는 foreach 문
	files.push("${path}"); //list 에서 하나씩 꺼내 path 에 담고 그 path 를 push() 를 사용해 files 배열에 하나 씩 담는다
	</c:forEach>
	
	console.log(files); //files 배열에 담은 값 확인
	
	if(files.length>0){ //업로드 된 파일이 있을 경우 //배열에 담긴 내용이 있다면
		
		var content="";
		
		for (var i = 0; i < files.length; i++) { //files 배열에 담긴 길이만큼 반복문
			console.log("fileName : "+files[i]); //풀 파일명
			var ext = files[i].substring(files[i].lastIndexOf(".")+1); //files의 i 번 인덱스(해당 파일명) 값에서 제일 마지막(lastIndexOf) . 의 다음 문자열부터 보여줘라(substring)
			console.log("ext : "+ext); //. 을 기준으로 자른 문자열 (. 을 제외한 확장자)
			
			if(ext == "jpg" || ext == "jpeg" || ext == "gif" || ext == "png" || ext == "jfif"){ //확장자가 다음 중 하나와 같다면 
				content += '<img width="500" src="/photoFile/'+files[i]+'"/>'; // <img width="500" src="/photo/파일명"/> 태그 를 content 에 담음 (/photo 는 C:/upload)
			}else{ //해당 확장자가 아니라면
				content += '<a href="/photo/'+files[i]+'">'+files[i]+' 다운로드 </a>'; //<a href="/photo/파일명">파일명 다운로드</a> 태그 담음
			}
			content += '<a href="delete?file='+files[i]+'">삭제</a>';
			content += '<br/>';
		}
		$("#area").html(content); //content 에 담은 내용을 id=area인 div의 html 에 출력
		
	}else { //업로드 된 파일이 없을 경우
		$("#area").html("<P>업로드 된 파일이 없습니다.</p>");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
</script>
</html>