package co.kr.gudi.member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.gudi.member.dto.MemberDTO;
import co.kr.gudi.member.service.MemberService;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberService memberService;

	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {
		logger.info("회원가입 페이지로 이동");
		return "joinForm";
	}
	
	
	@GetMapping(value = "/overlay")
	@ResponseBody
	public HashMap<String, Object> overlay(@RequestParam String id){
		logger.info("중복확인 : {}",id);
		HashMap<String, Object> map = new HashMap<String, Object>();
		boolean overlay= memberService.overlay(id);
		map.put("overlay", overlay);
		return map;
	}
	
	//DTO 로 파라메터 받기
	//1. @ModelAttribute 로 파라메터를 받을 것
	//2. parameter 명이 DTO 필드와 같을 것
	//3. POST 로 전송할 것
	@PostMapping(value = "/join")
	public String join(@ModelAttribute MemberDTO dto) {
		String page = "joinForm";
		logger.info("회원가입 요청 : {}",dto.getId());
		int result = memberService.join(dto);
		if (result>0) {
			page = "login";
		}
		return page;
	}
	
	@PostMapping(value = "/login")
	public String login(@RequestParam String id, @RequestParam String pw, HttpSession session) {
		logger.info("로그인 요청 : {}/{}",id,pw);
		String page = "login";
		
		if (memberService.login(id,pw)) {
			page="redirect:/list";
			session.setAttribute("loginId",id);
		}
		
		return page;
	}
	
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session){
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	

}
