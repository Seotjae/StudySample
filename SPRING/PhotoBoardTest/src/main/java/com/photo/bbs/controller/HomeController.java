package com.photo.bbs.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.photo.bbs.dto.BoardDTO;
import com.photo.bbs.dto.PhotoDTO;
import com.photo.bbs.service.PhotoBoardService;

@Controller
public class HomeController {
	
	@Autowired PhotoBoardService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/error/404", method = RequestMethod.GET)
	public String NotFound(Model model) {
		logger.info("404 error");
		model.addAttribute("code","404");
		model.addAttribute("msg","페이지를 찾을 수 없습니다.");
		return "error";
	}
	
	@RequestMapping(value = "/error/500", method = RequestMethod.GET)
	public String IOException(Model model) {
		logger.info("500 error");
		model.addAttribute("code","500");
		model.addAttribute("msg","입출력 과정에서 문제가 발생했습니다.");
		return "error";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("home_list 요청");
		ArrayList<BoardDTO> list = service.list();
		logger.info("가져온 list : {}",list);
		model.addAttribute("list",list);	
		return "test";
	}
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model) {
		logger.info("writeForm 요청");
		return "writeForm";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model,MultipartFile[] photos,@RequestParam HashMap<String, String> params) {
		logger.info("write 요청 : {}",params);
		logger.info("photo upload 요청 : "+photos.length);
		return service.write(photos,params);
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,@RequestParam String idx) {
		logger.info("detail 요청");
		BoardDTO dto = service.detail(idx);
		logger.info("가져온 dto : {}", dto);
		ArrayList<PhotoDTO>photolist=service.photolist(idx);
		logger.info("가져온 photolist : {}",photolist);
		model.addAttribute("dto",dto);
		model.addAttribute("photos",photolist);
		return "detail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
