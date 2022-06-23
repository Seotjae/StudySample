package com.spring.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.dao.MemberDAO;
import com.spring.member.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired MemberDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public int login(String id, String pw) {
		logger.info("DB에 로그인 요청 : {}/{}",id,pw);
		return dao.login(id,pw);
	}

	public ArrayList<MemberDTO> list() {
		logger.info("DB에 회원 목록 요청");
		return dao.list();
	}

	public String join(MemberDTO dto) {
		logger.info("회원가입 service 도착");
		String page = "joinForm";
		if (dao.join(dto) > 0) {
			page ="login";
		}	
		return page;
	}

	public String join_map(HashMap<String, String> params) {
		logger.info("회원가입 service 도착");
		String page = "joinForm";
		if (dao.join_map(params) > 0) {
			page ="login";
		}	
		return page;
	}
	
	
	//ModelAndView : Model + View , 이 안에 전달할 테이터와 페이지 명을 넣는 객체
	//어디에서나 생성이 가능
	public ModelAndView search(HashMap<String, String> params) {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<MemberDTO> list = dao.search(params);
		mav.addObject("list",list);
		
		mav.setViewName("list"); //가고싶은 jsp 파일명
		
		
		
		
		return mav;
	}

	public ModelAndView update(HashMap<String, String> params) {
		
		ModelAndView mav =new ModelAndView();
		mav.setViewName("redirect:/list");
		int success = dao.update(params);
		//redirect 사용 시 데이터를 담아 보낼 수 없다
		logger.info("update 성공 : {}",success);
		return mav;
	}

	public ModelAndView multi(ArrayList<String> name) {
		ModelAndView mav = new ModelAndView();
		ArrayList<MemberDTO> list = dao.multi(name);
		logger.info("검색 결과 : {}",list.size());
		mav.setViewName("list");
		mav.addObject("list",list);
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
