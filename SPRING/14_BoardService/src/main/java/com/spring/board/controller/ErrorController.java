package com.spring.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/error") //컨트롤러에도 적용 가능
public class ErrorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/sqlError", method = RequestMethod.GET) // 실제로 /error/sqlError 로 호출된다
	public ModelAndView home() {
		logger.info("에러 발생");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","글을 불러오는 중 문제가 발생했습니다. 잠시후 다시 시도해 주세요.");
		mav.addObject("link","./");
		mav.setViewName("error");
		return mav;
	}
	
	
}
