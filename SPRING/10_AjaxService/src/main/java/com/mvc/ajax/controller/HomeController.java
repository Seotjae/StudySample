package com.mvc.ajax.controller;

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

import com.mvc.ajax.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired MemberService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("login page 이동");
		return "login";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {
		logger.info("joinForm page 이동");
		return "joinForm";
	}
	
	//ajax 통신 - 중복 아이디 확인
	@RequestMapping(value = "/overlay", method = RequestMethod.GET) //get 방식의 overlay 요청을 받으면 아래의 메서드 실행
	@ResponseBody //객체 자체를 전송하기 위한 어노테이션
	public HashMap<String, Object> overlay(@RequestParam String id) { //오버레이 메서드를 실행하면 반환하는 타입이 hashmap (jackson 으로 js가 받을 수 있게 변환하기 위해서 hashmap 사용)
		logger.info("아이디 중복 확인 : {}", id);
		return service.overlay(id); //service의 오버레이 메서드를 호출하고 실행  -> 반환 받은 map 을 ajax 에 응답
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST) 
	@ResponseBody //객체 자체를 전송하기 위한 어노테이션
	public HashMap<String, Object> join(@RequestParam HashMap<String, String> params) { 
		logger.info("회원가입 요청 : {}", params);
		return service.join(params);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	@ResponseBody //객체 자체를 전송하기 위한 어노테이션
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
