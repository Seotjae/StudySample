package com.spring.main.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.main.service.JoinService;

@Controller
public class HomeController {
	
	//@Autowired : 특정 클래스를 객체화 하지 않고 사용할 수 있도록 해준다
	@Autowired JoinService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("회원가입 페이지 이동");
		//1. "/" 요청이 오면 home.jsp 로 이동시킨다
		return "home";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model,@RequestParam HashMap<String, String> params) {
		//이전에는 POST 로 한글을 보낼 때 request.setCharacterEncoding("UTF-8") 로 처리했다
		//Spring 에서 web.xml 에 설정을 해두면 된다
		logger.info("회원가입 요청");
		//파라메터 받는 방법 
		//- request.getParameter("name") -> 스프링에서 잘 사용하지 않음
		//- @RequestParam String name -> 1~2 건으로 들어오는 파라메터에 대해서 사용
		//- @RequestParam HashMap<String, String> name -> 3개 이상 파라메터 받을 경우 사용
		logger.info("params : {}",params);
		
		
		
		//3. 들어온 요청에 대해서 누구에게 시킬것인지 결정한다
		//4. 적합한 서비스에게 요청한다
		
		return "result";
	}
	
}
