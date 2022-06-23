package com.spring.main;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller //이 클래스는 컨트롤러 라고 설정
public class HomeController {
	
	//로그를 찍어주는 설정 (System.out.println 을 대체)
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	// "/" 로 요청이 오면 아래 메서드를 실행하라 (GET 방식으로 전송했을 경우만 받아줘라)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		logger.info("home page 로 요청이 들어옴");
		model.addAttribute("msg","Hello Spring Framework"); //model 은 특정 페이지로 보내고 싶은 내용을 담는 객체
		
			
		return "home"; //home.jsp 로 보내라
	}
	
	// "/paramPage" 로 요청이 오면 아래 메서드를 실행하라 (GET 방식으로 전송했을 경우만 받아줘라)
	@RequestMapping(value = "/paramPage", method = RequestMethod.GET)
	public String paramPage(Model model, HttpServletRequest request) {
		
		String param = request.getParameter("param");
		logger.info("param : " + param); //logger 는 해당 내용이 어느 패키지 어느 클래스에서 일어났는지 알려줌
		
		String message = "invalid Type";
		
		if (param != null) {//null에 대한 방어코드
			if(param.equals("greeting")) {
				message = "안녕하세요";
			}
			if (param.equals("date")) {
				message = new Date().toString();
			}
		}
		model.addAttribute("msg",message);
		
		return "home"; //home.jsp 로 보내라
	}
	
}
