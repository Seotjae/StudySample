package com.mvc.ajax.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.ajax.dao.BoardDAO;
import com.mvc.ajax.dto.BoardDTO;

@Service
public class BoardService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardDAO dao;

	public ArrayList<BoardDTO> listCall() {
		logger.info("list call service : DAO 호출");
		return dao.listCall();
	}

	public int delete(ArrayList<String> delList) {
		int success = 0;
		for (String idx : delList) {
			success += dao.delete(idx);
		}
		logger.info("삭제할 개수 : {}",delList.size());
		logger.info("삭제 완료한 개수 : {}",success);
		
		return success;
	}

}
