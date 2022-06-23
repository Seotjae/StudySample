package com.mvc.bbs.sevice;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.bbs.dao.BoardDAO;
import com.mvc.bbs.dto.BoardDTO;

@Service
public class BoardService {
	
	@Autowired BoardDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ArrayList<BoardDTO> list() {
		logger.info("list 쿼리 요청");
		return dao.list();
	}
	
	public void write(HashMap<String, String> params) {
		int row = dao.write(params); //hashmap 자체를 XML 로 넘긴다
		logger.info("입력된 건수 : {}",row);
	}


	public BoardDTO detail(String idx, String method) {
		if (method.equals("detail")) {
			dao.upHit(idx); //조회수 올리기
		}
		return dao.detail(idx); //이후 데이터 가져오기
	}

	public void delete(String idx) {
		int success=dao.delete(idx);
		logger.info("삭제 완료 여부 : "+success);
	}

	public void update(HashMap<String, String> params) {
		int row = dao.update(params);
		logger.info("수정 성공 여부 : {}", row);
	}



}
