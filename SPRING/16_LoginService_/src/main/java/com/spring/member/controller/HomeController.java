package com.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.member.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired MemberService memberService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	
		return "login";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String id, @RequestParam String pw,HttpSession session, RedirectAttributes rAttr) {	
		logger.info("로그인 요청 : {}/{}",id,pw);
		String loginId = memberService.login(id,pw);
		logger.info("로그인 여부 : {}",loginId);
		
		String page = "redirect:/";
		String msg = "아이디와 비밀번호를 확인해 주세요";
		
		if (loginId != null) {
			session.setAttribute("loginId", loginId);
			page="redirect:/result";
			msg="반갑습니다 " +loginId+"님";
		}
		
		ModelAndView mav = new ModelAndView(page); //이동할 곳은 ModelAndView 에 지정
		//mav.addObject("msg",msg);
		rAttr.addFlashAttribute("msg",msg);
		return mav;
	}
	
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result() {	
		return "result";
	}
	
	
	
	
	
}
