package com.mvc.bbs.controller;

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

import com.mvc.bbs.dto.BoardDTO;
import com.mvc.bbs.sevice.BoardService;

@Controller
public class HomeController {
	
	@Autowired BoardService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("list 요청");
		//1. DB에서 bbs 테이블의 데이터를 가져와 담아 보낸다
		ArrayList<BoardDTO> list=service.list();
		logger.info("글의 수 : {}",list.size());
		model.addAttribute("size",list.size());
		model.addAttribute("list",list);
		return "list";
	}
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model) {
		logger.info("writeForm 이동");
		return "writeForm";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, @RequestParam HashMap<String, String> params) {
		logger.info("write 요청 : {}", params);
		service.write(params);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam String idx) {
		logger.info("detail 요청 : {}", idx);
		BoardDTO dto=service.detail(idx,"detail");
		model.addAttribute("info",dto);
		return "detail";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam String idx) {
		logger.info("삭제요청 : {}",idx);
		service.delete(idx);
		return "redirect:/";
	}
	

	//수정 페이지 이동
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model, @RequestParam String idx) {
		logger.info("updateForm 요청 : {}", idx);
		BoardDTO dto=service.detail(idx,"update");
		model.addAttribute("info",dto);
		return "updateForm";
	}	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model, @RequestParam HashMap<String, String> params) {
		logger.info("update 요청 : {}", params);
		service.update(params);
		return "redirect:/detail?idx="+params.get("idx");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
