package com.rest.main.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.main.dto.UserInfo;

//이걸 쓰면 ResponseBody 를 쓰지 않아도 된다. (ajax 전용)
//Spring 버전 4부터 사용 가능
//pom 에서 버전 업 해주고, jackson 라이브러리가 있어야 제대로 작동
@RestController
public class AjaxController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//testAjax?id=1
	@RequestMapping(value = "/testAjax", method = RequestMethod.GET)
	public HashMap<String, Object> testAjax(@RequestParam String id) {
		logger.info("testAjax 받은 id : "+id);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("send", id);
		map.put("msg", "OK");
		return map;
	}
	
	
	//페이지 이동을 해야할 경우는 ModelAndView 를 반환해야 한다
	
	//GET 과 POST 둘 다 받게하는 방법
	@RequestMapping(value = "rest/getNo/{id}", method = {RequestMethod.GET,RequestMethod.POST})
	public HashMap<String, Object> getNo(@PathVariable String id) {
		//요청 내용이 URL 을 통해서 나타난다
		logger.info("testAjax 받은 id : "+id);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("send", id);
		map.put("msg", "OK");
		return map;
	}
	
	
	@RequestMapping(value = "/rest/list", method = RequestMethod.GET)
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("하나");
		list.add("둘");
		list.add("셋");
		return list;
	}
	
	
	@RequestMapping(value = "/rest/dto", method = RequestMethod.GET)
	public UserInfo userInfo(){
		UserInfo info = new UserInfo();
		info.setId("admin");
		info.setName("Lee");
		info.setAge(33);
		info.setSuccess(true);
		return info;
	}
	
	
	
	

}
