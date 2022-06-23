package co.kr.gudi.bbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.gudi.bbs.dto.BoardDTO;
import co.kr.gudi.bbs.service.BoardService;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardService boardService;
	
	@GetMapping(value = "/list")
	public ModelAndView list() {
		return boardService.list();
	}
	
	@GetMapping(value = "/detail")
	public ModelAndView detail(@RequestParam String idx) {
		logger.info("상세보기 요청 : {}",idx);
		return boardService.detail(idx);
	}
	
	@GetMapping(value = "/del/{idx}")
	public ModelAndView del(@PathVariable String idx, RedirectAttributes rAttr) {
		logger.info("삭제 요청 : {}",idx);
		return boardService.del(idx, rAttr);
	}
	
	@GetMapping(value = "/writeForm")
	public String writeForm() {
		logger.info("글쓰기폼 요청");
		return "writeForm";
	}
	
	@PostMapping(value = "/write")
	public String write(@ModelAttribute BoardDTO dto) {
		logger.info("글쓰기 요청 : {}",dto.getSubject());
		return boardService.write(dto);
	}
	
	@GetMapping(value = "/updateForm/{idx}")
	public ModelAndView updateForm(@PathVariable String idx) {
		logger.info("업데이트 폼 요청 : {}",idx);
		return boardService.updateForm(idx);
	}
	
	
	@PostMapping(value = "/update")
	public ModelAndView update(@ModelAttribute BoardDTO dto) {
		logger.info("업데이트 요청 : {}",dto.getIdx());
		return boardService.update(dto);
	}
	
}
