package com.board.main.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.board.main.dao.BoardDAO;
import com.board.main.dto.BoardDTO;

@Service
public class BoardService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardDAO boardDAO;
	
	
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		logger.info("리스트 요청 서비스 도착");
		ArrayList<BoardDTO>list = boardDAO.list();
		mav.addObject("list",list);
		mav.addObject("size",list.size());
		 mav.setViewName("Home");
		return mav;
	}

}
