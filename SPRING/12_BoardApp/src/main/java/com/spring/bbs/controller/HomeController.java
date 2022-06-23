package com.spring.bbs.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.bbs.dto.BoardDTO;
import com.spring.bbs.service.BoardService;


@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardService service;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("리스트 요청 받음");
		
		ArrayList<BoardDTO> list = service.list();
		logger.info("가져온 리스트 수 : {}",list.size());
		model.addAttribute("list",list);
		model.addAttribute("size",list.size());

		return "list";
	}
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam String idx) {
		logger.info("상세보기 요청 : {}", idx);
		
		BoardDTO detail = service.detail(idx);
		logger.info("가져온 내용 : {}",detail);
		model.addAttribute("detail",detail);

		return "detailPage";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model,@RequestParam String idx) {
		logger.info("삭제 요청 받음 : {}",idx);
		service.delete(idx);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model) {
		logger.info("글쓰기 폼 이동 요청 받음");
		return "writeForm";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, @RequestParam HashMap<String, String> params) {
		logger.info("글쓰기 요청 받음 : {}",params);
		int idx = service.write(params);
		return "redirect:/detail?idx="+idx;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
