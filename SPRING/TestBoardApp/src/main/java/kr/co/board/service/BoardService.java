package kr.co.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.board.dao.BoardDAO;
import kr.co.board.dto.BoardDTO;

@Service
public class BoardService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardDAO dao;

	public ArrayList<BoardDTO> list() {
		 ArrayList<BoardDTO> list = dao.list();
		 logger.info("가져온 list : {}", list);
		return list;
	}

	public BoardDTO detail(String idx, String detail) {
		if (detail.equals("detail")) {
			dao.plus(idx);
		}
		BoardDTO dto = dao.detail(idx);
		logger.info("가져온 detail : {}",dto);
		return dto;
	}

	public void write(HashMap<String, String> params) {
		int result = dao.write(params);
		logger.info("write 결과 : {}", result);
	}

	public void del(String idx) {
		int result = dao.del(idx);
		logger.info("del 결과 : {}",result);
	}

	public void update(HashMap<String, String> params) {
		int result = dao.update(params);
		logger.info("update 결과 : {}", result);
	}

	public void test(HashMap<String, Object> params) {
		logger.info("파라미터 : {}",params);
		ArrayList<HashMap<String,Object>>  test = dao.test(params);
	
		logger.info("결과 : {}",test);
		
		
	}

	public ArrayList<Integer> ptv() {
		return dao.ptv();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
