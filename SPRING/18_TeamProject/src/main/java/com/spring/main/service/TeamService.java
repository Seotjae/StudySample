package com.spring.main.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.dao.TeamDAO;

@Service
public class TeamService {
	
	@Autowired TeamDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public HashMap<String, Object> list() {
		logger.info("list 요청 서비스 도착");
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<HashMap<String, String>> list = dao.list();
		logger.info("size"+list.size());
		map.put("list", list);
		return map;
	}

	public HashMap<String, Object> update(String col, String val, String pk) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int result = dao.update(col,val,pk);
		String msg ="수정에 실패 했습니다.";
		if (result>0) {
			msg="수정에 성공했습니다.";
		}
		map.put("msg",msg);
		return map;
	}


}
