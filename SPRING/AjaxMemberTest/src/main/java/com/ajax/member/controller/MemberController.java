package com.ajax.member.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajax.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired MemberService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("로그인 페이지 이동");
		return "test";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {
		logger.info("회원가입 페이지 이동");
		return "joinForm";
	}
	
	@RequestMapping(value = "/overlay", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> overlay(@RequestParam String id) {
		logger.info("중복확인 요청 : {}",id);
		return service.overlay(id);
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> regist(@RequestParam HashMap<String, String> params) {
		logger.info("회원가입 요청 : {}",params);
		return service.regist(params);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	@ResponseBody
	public HashMap<String, Object> login(HttpSession session,@RequestParam String id, @RequestParam String pw) { 
		logger.info("로그인 요청 : {}/{}", id, pw);
		
		int success = service.login(id, pw);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (success>0) {
			session.setAttribute("loginId", id);
			logger.info("세션에 추가된 아이디 : {}",session.getAttribute("loginId"));
			map.put("loginId", id);
		}
		map.put("success", success);
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
}
