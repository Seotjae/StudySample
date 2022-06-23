<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//form.jsp 에서 받아온 값을 변수에 담아 system out 으로 출력
	String id = request.getParameter("id"); //클라이언트가 보낸 요청들을
	String pw = request.getParameter("pw"); //request 객체에서 getparameter 메서드로 꺼내서
	String name = request.getParameter("name"); //반환타입이 문자열이기 때문에 String 변수들에 각각 담아준다
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	
	System.out.println(id+"/"+pw+"/"+name+"/"+age+"/"+gender+"/"+email);
	
	Connection conn = null; //Connection을 담을 변수 conn 은 try 영역 밖에서도 사용해야 하기 때문에 전역 변수로 선언한다
	PreparedStatement ps = null; //PreparedStatement을 담을 변수 ps는 try 영역 밖에서도 사용해야 하기 때문에 전역변수로 선언한다
	
	try{ //DB 에 접속하고 DB를 사용하는 과정에서 예외가 발생하는 것을 확인하고 처리하기 위해서 try catch 문을 사용한다
		//context.xml 에 담긴 정보들을 자바에서 사용하기 위해서 파일을 Context 타입으로 객체화하고 변수 ctx에 넣는다
		Context ctx = new InitialContext(); //1. Context.xml 객체로 만들기 
		
		//객체화한 ctx의 lookup 메서드를 사용해서 context 파일에서 name이 jdbc/MariaDB 인 Resource를 찾아오고 DataSource로 변환해서 ds에 넣는다 (lookup 은 Object 타입을 반환하기 때문에 캐스팅이 필요하다)
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB"); //2. Resource 를 name 으로 찾아서 DataSource 객체로 만들기 
		
		//ds 에서 connection 을 가져와 커넥션을 생성하고 변수 conn 에 넣는다
		conn = ds.getConnection(); //3. DataSource 로 Connection 가져오기
		
		//sql 변수에 테이블에 값을 넣기위핸 insert into 쿼리문을 준비해서 넣어둔다. 여기서 물음표(?) 는 테이블에 들어갈 값이 정해져 있지 않음을 나타낸다
		String sql = "insert into member(id,pw,name,age,gender,email)values(?,?,?,?,?,?)"; //4-1 쿼리문 준비 (어떤 값이 들어올지 모른다)
		
		//커넥션에서 제공하는 prepareStatement을 생성하고 실행시킬 쿼리문을 넣는다.
		ps = conn.prepareStatement(sql);//4-2 PreparedStatement 생성
		
		//PreparedStatement의 메서드를 사용해 쿼리문의 물음표에 대응해 들어갈 값을 지정해준다
		ps.setString(1, id); //4-3 각 ? 에 대한 대응 //1번 물음표에 String 형태의 id 변수가 들어갈 것이다
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setInt(4, Integer.parseInt(age)); //4번 물음표엔 int 형태로 들어갈건데 현재 age 변수가 String 형태이기 때문에 int로 변환해준다
		ps.setString(5, gender);
		ps.setString(6, email);
		
		//PreparedStatement로 쿼리를 실행시켜준다 (executeUpdate는 데이터에 변화가 생기는 쿼리문들을 실행할 때 사용하는 메서드이다)
		//이 메서드는 int 의 값을 반환하고 반환하는 값은 쿼리가 실행됨으로 변화된 행의 수이다, 따라서 0이면 실패
		int success = ps.executeUpdate(); //4-4 쿼리 실행 (executeUpdate -> 뭔가 데이터에 변화가 생기는 쿼리문 실행시 사용) //쿼리 실행으로 인해 변화한 행의 수를 반환
		
		if(success>0){ //반환된 값을 가지고 
			out.println("<h3>데이터 입력 성공</h3>"); //반환된 값이 0보다 크면 성공
		}else{
			out.println("<h3>데이터 입력 실패</h3>"); //반환된 값이 0이면 실패
		}
		
	}catch(Exception e){ //예외가 발생한다면
		e.printStackTrace(); //발생한 예외를 표시하고
		out.println("<h3>데이터 입력 실패</h3>"); //다음 내용을 html에 출력한다
	}finally{ //5. 사용한 자원 반납하기 //예외 발생 여부와 상관 없이 무조건 실행할 내용들
		ps.close(); //위에서 사용한 preparedstatement 를 닫고
		conn.close(); //connection 도 닫는다
	}
%>
