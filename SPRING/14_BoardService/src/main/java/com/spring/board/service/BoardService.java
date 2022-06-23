package com.spring.board.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.dao.BoardDAO;
import com.spring.board.dto.BoardDTO;

@Service
public class BoardService {
	
	@Autowired BoardDAO dao;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		ArrayList<BoardDTO> list = dao.list();
		logger.info("불러온 리스트 : {}",list.size());
		mav.addObject("list",list);
		mav.addObject("size",list.size());
		return mav;
	}
	
	
	//두 개의 쿼리가 실행되는 메서드에 트랜잭션 적용
	@Transactional
	public ModelAndView detail(String idx) {
		//try catch 를 사용해서 예외처리를 할 경우 transaction rollback 이 되지 않는다
		logger.info("service 도착 : {}",idx);
		ModelAndView mav = new ModelAndView();
		dao.upHit(idx);//1. 조회수 올리기
		BoardDTO dto = dao.detail(idx);
		mav.addObject("detail",dto);
		mav.setViewName("detail");
		return mav;
	}
	
	
	
}
