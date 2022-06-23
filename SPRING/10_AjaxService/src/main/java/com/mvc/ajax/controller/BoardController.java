package com.mvc.ajax.controller;

import java.util.ArrayList;
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

import com.mvc.ajax.dto.BoardDTO;
import com.mvc.ajax.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//컨트롤러가 몇개이던지 RequestMapping 의 value 값은 유일해야 한다.
	//Controller 이름을 차용해서, value = "/board/list", 이런 식으로 많이 사용
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		logger.info("list.jsp 로 이동");
		
		String page = "redirect:/";
		
		String loginId = (String) session.getAttribute("loginId");
		if (loginId != null) {
			logger.info("로그인 한 아이디 : "+loginId);
			page = "list";
		}		
		return page;
	}
	
	@RequestMapping(value = "/listCall", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> listCall(HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("loginId") == null) {
			map.put("msg", "로그인이 필요한 기능 입니다.");
		}else {
			logger.info("리스트 불러오기");
			
			ArrayList<BoardDTO> list= service.listCall();
			map.put("list",list);
			map.put("count", list.size());
		}
		return map;
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> delete( //배열로 오는 파라메터를 받을 경우 반드시 명시해 줘야한다
			@RequestParam (value="delList[]") ArrayList<String> delList) { 
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		logger.info("deList : {}",delList);
		int delCnt = delList.size(); //1. 삭제할 개수를 확인
		int row = service.delete(delList);//2. 삭제 완료된 개수 확인
		
		//3. 1번과 2번이 같으면 완료
		map.put("msg", delCnt+"개 요청 중 "+row+"개를 삭제했습니다.");
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
