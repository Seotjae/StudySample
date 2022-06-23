package com.spring.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	
	//405 – 허용되지 않는 메소드 ( Request method 'POST' not supported)
	//보내는 쪽에서 post 로 보낼 때 받는 쪽도 post 로 받아줘야 한다
	@RequestMapping(value = "/calc", method = RequestMethod.POST)
	public String calc(Model model,@RequestParam String su1,@RequestParam String su2,@RequestParam String oper) {
		//request 에서 parameter를 받아올 경우 @RequestParam 으로 받아올 수 있다
		logger.info(su1+oper+su2);
		
		int val1 =Integer.parseInt(su1);
		int val2 = Integer.parseInt(su2);
		Object result = null;
		
		//자바 1.6은 switch 문에 문자열을 받을 수 없다 (오직 숫자만..)
		switch(oper) {
			case "+":
				result = val1+val2;
				break;
				
			case "-":
				result = val1-val2;
				break;
				
			case "*":
				result = val1*val2;
				break;
				
			case "/":
				result = val1/val2;
				break;
		}
		logger.info("result : " + result);
		model.addAttribute("result", result); //String, Object
		
		return "result";
	}
	
	
}
