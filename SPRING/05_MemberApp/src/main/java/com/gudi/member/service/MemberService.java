package com.gudi.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudi.member.dao.MemberDAO;
import com.gudi.member.dto.MemberDTO;

@Service
public class MemberService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberDAO dao;

	public String join(HashMap<String, String> params) {
		logger.info("회원 가입 서비스");
		
		String msg = "회원가입에 실패 했습니다";
		//DB 사용 여부? -> DAO (Data Access Object) 를 사용
		String id = params.get("id");
		String pw = params.get("pw");
		String name = params.get("name");
		String age = params.get("age");
		String gender = params.get("gender");
		String email = params.get("email");
		
		//체크포인트2. 전달할 파라메터를 제대로 뽑아왔는가?
		logger.info(id+"/"+pw+"/"+name+"/"+age+"/"+gender+"/"+email);
		
		int row = dao.join(id,pw,name,age,gender,email);
		//체크포인트3. 성공 여부 확인
		logger.info("insert 성공 여부 : " + row);
		
		if (row>0) {
			msg="회원가입에 성공 했습니다.";
		}
		
		
		return msg;
	}

	public String login(String id, String pw) {
		String loginId = null;
		
		//DB 가 필요한가?
		loginId = dao.login(id,pw);
		
		
		
		return loginId;
	}

	public ArrayList<MemberDTO> list() {
		
		ArrayList<MemberDTO> list = null;
		//DB 가 필요
		list = dao.list();
		logger.info("size : {}", list.size());
		return list;
	}

	public int del(String id) {
		return dao.del(id);
	}

	public MemberDTO detail(String id) {
		//DAO 에서 받은 내용을 그냥 컨트롤러로 바로 전달
		return  dao.detail(id);
	}

	public void update(HashMap<String, String> params) {
		String id = params.get("id");
		String pw = params.get("pw");
		String name = params.get("name");
		String age = params.get("age");
		String gender = params.get("gender");
		String email = params.get("email");
		
		//체크포인트2. 전달할 파라메터를 제대로 뽑아왔는가?
		logger.info(id+"/"+pw+"/"+name+"/"+age+"/"+gender+"/"+email);
		
		int row = dao.update(id,pw,name,age,gender,email);
		logger.info("수정 성공 여부 : "+row);
		
		
		
	}


	

}
