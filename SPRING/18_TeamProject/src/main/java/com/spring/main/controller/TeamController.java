package com.spring.main.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.main.service.TeamService;

@RestController
public class TeamController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired TeamService service;
	
	@RequestMapping (value = "/list")
	public HashMap<String, Object> list(){
		logger.info("list 요청");
		return service.list();
	}

	@RequestMapping (value = "/update/{col}/{val}/{pk}")
	public HashMap<String, Object> update(@PathVariable String col,@PathVariable String val,@PathVariable String pk){
		logger.info("update 요청 : "+col+"/"+val+"/"+pk);
		return service.update(col,val,pk);
	}
	
	
	
}
