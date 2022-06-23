package com.spring.member.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.dto.MemberDTO;
import com.spring.member.service.MemberService;


@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("로그인 페이지 이동");
		return "login";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model,@RequestParam String id,@RequestParam String pw,HttpSession session) {
		logger.info("로그인 요청 : {}/{}",id,pw);
		int loginResult = service.login(id,pw);
		logger.info("로그인 결과 : {}",loginResult);
		model.addAttribute("loginResult",loginResult);
		String page = "login";
		if (loginResult>0) {
			session.setAttribute("loginId", id);
			page = "redirect:/list";
		}
		return page;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		logger.info("회원 목록 요청");
		ArrayList<MemberDTO> list = service.list();
		logger.info("불러온 회원 목록 수 : {}",list.size());
		model.addAttribute("list",list);	
		return "list";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model,HttpSession session) {
		logger.info("로그아웃 요청");
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model,HttpSession session) {
		logger.info("회원가입 페이지 이동");
		return "joinForm";
	}
	
	
	//보내는 파라메터와 dto 의 필드명이 같을 경우 dto 형태로 받을 수 있다
	//조건 1. view 에서 POST 로 보내야 된다.
	//조건 2. @ModelAttribute 를 사용해야 한다. (버전 향상 되면서 이건 사라짐)
	//조건 3. DTO 필드에 해당하는 모든 값이 있어야 한다.
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model,@ModelAttribute MemberDTO dto) {
		logger.info("회원가입 요청");
		logger.info("dto : {}",dto.getId());
		return service.join(dto);
	}
	
	@RequestMapping(value = "/join_map", method = RequestMethod.POST)
	public String join_map(Model model,@RequestParam HashMap<String, String> params) {
		logger.info("회원가입 요청");
		logger.info("params : {}",params);
		return service.join_map(params);
	}
	
	
	//model 은 데이터를 view 에 전달하는 역할 수행
	//컨트롤러에서만 생성이 가능 (파라메터 형태로)
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam HashMap<String, String> params) {
		logger.info("검색 요청");
		logger.info("params : {}",params);
		return service.search(params);
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam HashMap<String, String> params) {
		logger.info("수정 요청");
		logger.info("params : {}",params);
		return service.update(params);
	}
	
	
	//같은 name 으로 여러개가 들어올 경우 ArrayList 로 파라메터를 받는다
	@RequestMapping(value = "/multi", method = RequestMethod.POST)
	public ModelAndView multi(@RequestParam ArrayList<String> name) {
		logger.info("사람 찾기 요청");
		logger.info("params : {}",name);
		return service.multi(name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
