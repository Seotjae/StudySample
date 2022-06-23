package com.test.board.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.test.board.dao.BoardDAO;
import com.test.board.dto.BoardDTO;

@Service
public class BoardService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardDAO dao;

	public ModelAndView list() {
		logger.info("list 요청 서비스 도착");
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardDTO> list = dao.list();
		logger.info("불러온 리스트 수 : "+list.size());
		mav.addObject("size",list.size());
		mav.addObject("list",list);
		mav.setViewName("list");
		return mav;
	}

	public String write(String user_name, String subject, String content) {
		logger.info("write 요청 서비스 도착 : "+user_name+"/"+subject+"/"+content);
		BoardDTO dto = new BoardDTO();
		dto.setUser_name(user_name);
		dto.setSubject(subject);
		dto.setContent(content);
		int result = dao.write(dto);
		logger.info("작성 결과 : "+result);
		String page = "writeForm";
		if (result>0) {
			int idx = dto.getIdx();
			logger.info("작성한 글 번호 : "+idx);
			page = "redirect:/detail?idx="+idx;
		}
		return page;
	}

	@Transactional
	public ModelAndView detail(String idx) {
		logger.info("detail 요청 서비스 도착 : "+idx);
		dao.upHit(idx);
		BoardDTO detail =dao.detail(idx);
		logger.info("불러온 상세보기 : {}",detail);
		ModelAndView mav = new ModelAndView();
		mav.addObject("detail",detail);
		mav.setViewName("detail");
		return mav;
	}

	public void delete(String idx) {
		logger.info("delete 요청 서비스 도착 : "+idx);
		dao.delete(idx);
		
	}

}
