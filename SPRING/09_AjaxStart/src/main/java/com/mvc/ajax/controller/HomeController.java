package com.mvc.ajax.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("login page 이동");
		return "login";
	}
	
	//ajax 요청은 기존 방식대로 처리하면 응답에 대해 parsererror 를 발생 시킨다
	//그래서 ajax 는 방식을 바꿔야 한다 (java 에서 보낸 내용을 js 에서 알 수 있도록 변경해주는 라이브러리가 필요, 수 많은 라이브러리 중 잭슨 사용)
	//dataType:'JSON' 이기 때문에 우리는 Java Script Object 형태로 client 에 전달해야 한다
	//{"key","value"} 형태의 자바 객체는 무엇이 있을까? -> HashMap
	//우리는 HashMap 으로 전달할 내용을 담고 JACKSON 이 JS 가 알아들을 수 있도록 변형시켜 준다
	@RequestMapping(value = "/login")
	@ResponseBody 
	public HashMap<String, Object> login(Model model,@RequestParam String id,@RequestParam String pw) {
		logger.info("login 요청 : {} / {}",id,pw);
		//model.addAttribute("msg","로그인에 성공했습니다");
		HashMap<String, Object> json = new HashMap<String, Object>();
		json.put("msg", "로그인에 성공 했습니다.");
		return json;
	}
	
	@RequestMapping(value = "/include", method = RequestMethod.GET)
	public String include(Model model) {
		logger.info("include page 이동");
		return "include";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
