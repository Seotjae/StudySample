package com.rest.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	
	/*
	@RequestMapping(value = "/testAjax", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> testAjax(@RequestParam String id) {
		logger.info("testAjax 받은 id : "+id);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("send", id);
		map.put("msg", "OK");
		return map;
	}
	*/
	
	
	
	
	
}
