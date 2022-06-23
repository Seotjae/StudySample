package com.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView login(@RequestParam String id,@RequestParam String pw,HttpSession session) {
		logger.info("로그인 요청 : {}/{}",id,pw);
		ModelAndView mav = new ModelAndView("redirect:/");
		String loginId = service.login(id,pw);
		logger.info("로그인 결과 : {}",loginId);
		if (loginId != null) {
			session.setAttribute("loginId", loginId);
			mav.setViewName("result");
		}
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
