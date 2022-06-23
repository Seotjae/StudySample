package com.spring.encode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	String hashText="";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/join")
	public String join(Model model,@RequestParam String pass) {
		logger.info("암호화할 값 : "+pass);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		hashText = encoder.encode(pass);
		logger.info("암호화된 값 : "+hashText);
		//값을 입력하면서 암호화 패턴을 파악할 수 있으므로 sault 라는 값을 추가하여 같은 값을 넣어도 다르게 암호화 하게 한다
		
		
		return "home";
	}
	
	@RequestMapping(value = "/confirm")
	public String confirm(Model model,@RequestParam String pass) {
		logger.info("확인할 값 : "+pass);
		//이 평문을 어떻게 암호화한 값과 비교해서 맞는지 찾을 것인가?
		//BCryptPasswordEncoder 클래스의 matches 메서드 사용해서 boolean 값 확인
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean result = encoder.matches(pass, hashText);
		if (result) {
			model.addAttribute("msg","암호문이 일치 합니다.");
		}else {
			model.addAttribute("msg","암호문이 일치하지 않습니다.");
		}

		return "home";
	}
	
	
	
	
	
	
	
	
	
}
