<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	/*로그인 절차*/
//1. 사용자로부터 아이디와 비밀번호를 받아온다
	String id = request.getParameter("id"); //request 에서 클라이언트가 전송한 id 라는 name 의 값을 받아와 id 문자열 변수에 담는다
	String pw = request.getParameter("pw"); //클라이언트가 전송한 pw 라는 name 의 값을 받아와 pw 문자열 변수에 담는다
	System.out.println(id+"/"+pw);

//2. DB 에 저장된 값으로 있는지 확인해 본다 (이 부분은 간단하게 대체)
	String user_id = "admin"; //user_id 와 user_pw 가 DB 에 있는 값이라고 가정하고
	String user_pw = "pass";

	if(id.equals(user_id) && pw.equals(user_pw)){ //3. 있으면 로그인 처리(세션에 로그인 성공 유저라는 값을 준다) //사용자로 부터 받아온 id 와 pw 가 user_id 와 user_pw 일치한다면
		session.setAttribute("loginId", id); //이제부터 loginId 값 유무로 로그인 여부를 판단 //세션의 setAttribute 로 loginId 라는 속성에 id 의 값을 넣는다
	}else{ //4. 없으면 로그인 페이지로 이동 //일치하지 않는다면 
		response.sendRedirect("login.jsp");	//login.jsp 로 페이지를 이동 시킨다
	}	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 성공</h2>
	안녕하세요 <%=session.getAttribute("loginId")%>님, 반갑습니다. <!-- 로그인에 성공하면 세션에 등록되어 있는 loginId 값을 포함한 이 문구를 출력한다-->
	<button onclick="logout()">로그아웃</button>
</body>
<script>
	function logout() {
		location.href='logout.jsp' //로그아웃 버튼을 누르면 logout.jsp 페이지로 이동시키는 문장
	}
</script>
</html>