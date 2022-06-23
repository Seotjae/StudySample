package com.mvc.photo.controller;

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

import com.mvc.photo.dto.BoardDTO;
import com.mvc.photo.dto.PhotoDTO;
import com.mvc.photo.service.PhotoService;

@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired 는 여러 개 할 수 있다
	@Autowired PhotoService service;
	
	//Controller 도 여러 개 만들 수 있다
	//하지만 @RequestMapping 의 value 가 중복되면 안된다
	
	//404 에러 발생 시
	@RequestMapping(value = "/error/404", method = RequestMethod.GET)
	public String notfound(Model model) {
		logger.info("404 error 발생");
		model.addAttribute("code","404");
		model.addAttribute("msg","원하는 페이지를 찾지 못 했습니다.");
		return "error";
	}
	
	//IOException 발생 시
	@RequestMapping(value = "/error/IOException", method = RequestMethod.GET)
	public String IOException(Model model) {
		logger.info("IOException 발생");
		model.addAttribute("code","500");
		model.addAttribute("msg","파일 입출력 과정에서 문제가 발생했습니다.");
		return "error";
	}
	
	// "/" 는 최초 요청이다, 따라서 첫 페이지로 보낼 곳을 지정하면 된다
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("게시판 리스트 불러오기");
		ArrayList<BoardDTO> list = service.list();
		logger.info("가져온 리스트 수 : {}",list.size());
		model.addAttribute("list",list);
		
		return "list";
	}
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam String idx) {
		logger.info("detail 요청 : {}",idx);
		 BoardDTO dto =service.detail(idx);
		 logger.info("reg_date : {}",dto.getReg_date());
		 model.addAttribute("dto",dto);
		 
		 ArrayList<PhotoDTO> photos = service.photoList(idx);
		 logger.info("사진 수 : {}",photos.size());
		 model.addAttribute("photos",photos);
		 
		
		return "detail";
	}
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model) {
		logger.info("writeForm 요청");
		return "writeForm";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST) //post 방식의 write 요청을 받으면 아래 메서드를 실행
	public String write(Model model, @RequestParam HashMap<String, String> params, MultipartFile[] photos) { //여러개의 파일은 photos 배열로, text 들은 hashmap 으로 파라메터를 받음
		logger.info("write 요청 : {}",params); //받은 파라메터들 확인
		logger.info("업로드할 파일 수 : {}",photos.length); 
		//서비스에서 어느 페이지로 보낼건지 결정
		return service.write(photos,params); //서비스로 파라메터들을 넘기고 write 메서드 실행 -> 문자열을 반환 (이동할 페이지 정보)
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam String idx) {
		logger.info("delete 요청 : {}",idx);
		service.delete(idx);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model,@RequestParam String idx) {
		logger.info("updateForm 요청 : {}",idx);	
		//페이지 이동은 꼭 Controller 에서만 하는건 아니다
		return service.updateForm(model,idx);
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST) 
	public String update(Model model, @RequestParam HashMap<String, String> params, MultipartFile[] photos) {
		logger.info("update 요청 : {}",params); 
		logger.info("업로드할 파일 수 : {}",photos.length); 

		return service.update(photos,params); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
