package kr.co.gudee.board.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudee.board.dao.BoardDAO;
import kr.co.gudee.board.dto.BoardDTO;

@Service
public class BoardService {
	
	@Autowired BoardDAO boardDAO;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
		
	public ModelAndView list() {
		logger.info("리스트 Board Service  도착");
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardDTO> dto = boardDAO.list();
		logger.info("불러온 리스트 크기 : {}",dto.size());
		mav.addObject("size",dto.size());
		mav.addObject("list",dto);
		mav.setViewName("list");
		return mav;
	}

	@Transactional
	public ModelAndView detail(String idx) {
		logger.info("{}번 상세보기 Board Service  도착",idx);
		ModelAndView mav = new ModelAndView();
		boardDAO.upHit(idx);
		BoardDTO dto = boardDAO.detail(idx);
		mav.addObject("detail",dto);
		mav.setViewName("detail");
		return mav;
	}

	public ModelAndView delete(String idx) {
		logger.info("{}번 삭제 Board Service  도착",idx);
		boardDAO.delete(idx);
		return new ModelAndView("redirect:/list");
	}

}
