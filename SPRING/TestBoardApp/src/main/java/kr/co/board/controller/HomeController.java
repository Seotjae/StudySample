package kr.co.board.controller;

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

import kr.co.board.dto.BoardDTO;
import kr.co.board.service.BoardService;

@Controller
public class HomeController {
	
	@Autowired BoardService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		ArrayList<Integer>ptv = service.ptv();
		model.addAttribute("ptv",ptv);
		return "test";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String check(Model model, @RequestParam String point) {
		logger.info("받은 값 : {}",point);
		model.addAttribute("point",point);
		return "check";
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public String pay(Model model, @RequestParam String val) {
		logger.info("금액 : "+val);
		return "check";
	}
	
	

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		ArrayList<Integer> meet_region = new ArrayList<Integer>();
		meet_region.add(1);
		ArrayList<Integer> meet_interest = new ArrayList<Integer>();
		meet_interest.add(1);
		meet_interest.add(2);
		String keyword = "";
		int meet_point = 0;
		logger.info("모임비"+meet_point);
		HashMap<String,Object> params = new HashMap<String, Object>();
		params.put("meet_region", meet_region);
		params.put("meet_interest", meet_interest);
		params.put("meet_subject", keyword);
		params.put("meet_point", meet_point);
		service.test(params);
		return "test";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam String idx) {
		logger.info("detail 요청 : {}", idx);
		BoardDTO dto = service.detail(idx,"detail");
		model.addAttribute("content",dto);
		return "detail";
	}
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model) {
		logger.info("writeForm 이동");
		return "writeForm";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, @RequestParam HashMap<String, String> params) {
		logger.info("write 이동 : {}",params);
		service.write(params);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Model model, @RequestParam String idx) {
		logger.info("del 이동 : ",idx);
		service.del(idx);
		return "redirect:/";
	}	
	
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model,@RequestParam String idx) {
		logger.info("updateForm 이동");
		BoardDTO dto = service.detail(idx,"update");
		model.addAttribute("content",dto);
		return "updateForm";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model, @RequestParam HashMap<String, String> params) {
		logger.info("update 요청 : {}",params);
		service.update(params);
		return "redirect:/detail?idx="+params.get("idx");
	}
	
	
	
	
	
	
	
	
	
}
