package com.gudi.member.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gudi.member.dto.MemberDTO;
import com.gudi.member.service.MemberService;


@Controller
public class HomeController {
	
	//복붙하기 편하게 하기 위해서
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Service 객체화 하지 않고 불러오기 설정
	//@Autowired 는 딱 하나의 객체만 생성해서 재활용하게 해 준다 (싱글톤 패턴)
	@Autowired MemberService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("로그인 페이지 이동"); //logger 는 String 외에는 찍어주지 않는다 (숫자 등을 찍을 때는 다른 방법이 있다)
		
		return "login";
	}
	//요청명과 컨트롤러 메서드 명은 서로 일치 시켜주자 (학원에서의 약속)
	@RequestMapping(value="/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {
		logger.info("회원가입 페이지 이동 요청");
		return "joinForm";
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(Model model, @RequestParam HashMap<String, String> params) {
		logger.info("회원가입 요청");
		//체크포인트 1. 파라메터가 정상적으로 들어 왔는가?
		logger.info("params : {}",params); //logger 에는 기본적으로 문자열만 표시된다
		
		String msg = service.join(params); //join 에게 요청하면 성공/실패 메시지 반환
		
		String page = "joinForm"; //기본은 실패한 값
		
		//성공여부
		if (msg.equals("회원가입에 성공 했습니다.")) { //성공 여부
			page = "login";
		}
		
		model.addAttribute("msg", msg); //메시지를 담아 보낸다
		
		return page;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam String id, @RequestParam String pw, HttpSession session) {
		logger.info("로그인 요청");
		logger.info(id+"/"+pw); //파라메터 확인
		
//		String page = "login"; //login.jsp 로 보낼 때
		String page = "redirect:/"; // "/" 라는 요청을 보낼 때
		
		String loginId=service.login(id,pw);
		logger.info("로그인 한 아이디 여부 : " + loginId);
		
		if (loginId != null) {
			page = "redirect:/list";
			session.setAttribute("loginId", loginId);
		}
		
		return page;
	}
	
	//method = RequestMethod.POST 가 없으면 GET,POST,PUT,DELETE 를 모두 받겠다는 듯
	//편하긴 하지만 보안상 좋은 선택은 아니다
	@RequestMapping(value = "/list")
	public String list(Model model, HttpSession session) { 
		logger.info("리스트 페이지 이동"); //logger 는 String 외에는 찍어주지 않는다 (숫자 등을 찍을 때는 다른 방법이 있다)
			
		String page = "redirect:/";
		if (session.getAttribute("loginId") != null ) {//로그인 하지 않았으면 아래 내용을 실행 안함
			//DAO 에서 member 테이블의 id 와 name 가져옴
			//서비스에 회원 리스트를 요청, DTO를 만드는 이유 -> 데이터를 한꺼번에 담고 한방에 보내기 위한 클래스
			ArrayList<MemberDTO> list = service.list();//DTO 객체는 한 row 의 데이터만 담을 수 있기 때문에 arraylist 로 여러 데이터를 담을 수 있도록 한다
			model.addAttribute("list", list);
			page = "list";
		}
		
		
		return page;
	}	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		logger.info("로그아웃 요청");
		//session 에서 특정 속성만 제거하면 되기 때문에 서비스와 DAO 를 탈 필요가 없다
		session.removeAttribute("loginId");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Model model,HttpSession session, @RequestParam String id) {
		logger.info("삭제 요청 : {}", id);
		
		String page = "redirect:/";
		
		if (session.getAttribute("loginId") !=null) {
			page = "redirect:/list";
			int success = service.del(id);
			logger.info("삭제 여부 : {}", success);
		}

		return page;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam String id) {
		logger.info("상세보기 요청 : {}", id);
		MemberDTO dto = service.detail(id);
		model.addAttribute("info", dto);
		return "detail";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model, @RequestParam HashMap<String,String> params) {
		logger.info("수정 요청 : {}", params);
		service.update(params);
		
		//redirect 는 response 객체에서 나오므로 데이터를 실어 나를 수 없다
		//그래서 model 에 데이터를 담아 보낼 수 없다
		//원래 상세보기 페이지로 되돌아 간다
		return "redirect:/detail?id="+params.get("id");
	}
	
	
}
