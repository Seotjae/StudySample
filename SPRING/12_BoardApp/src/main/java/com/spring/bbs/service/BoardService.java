package com.spring.bbs.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bbs.dao.BoardDAO;
import com.spring.bbs.dto.BoardDTO;

@Service
public class BoardService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardDAO dao;

	public ArrayList<BoardDTO> list() {
		logger.info("DB 에 list 요청");
		return dao.list();
	}

	public BoardDTO detail(String idx) {
		logger.info("DB 에 detail 요청");
		dao.upHit(idx);
		return dao.detail(idx);
	}

	public void delete(String idx) {
		logger.info("DB 에 delete 요청");
		dao.delete(idx);
	}

	public int write(HashMap<String, String> params) {
		logger.info("DB 에 write 요청");
		BoardDTO dto = new BoardDTO();
		String user_name = params.get("user_name");
		String subject = params.get("subject");
		String content = params.get("content");
		
		logger.info("받은 파라메터 : "+user_name+"/"+subject+"/"+content);
		
		dto.setUser_name(user_name);
		dto.setSubject(subject);
		dto.setContent(content);
		
		dao.write(dto);
		int idx = dto.getIdx();
		logger.info("작성한 글 번호 : {}",idx);
		
		return idx;
	}


	
	
	
}
