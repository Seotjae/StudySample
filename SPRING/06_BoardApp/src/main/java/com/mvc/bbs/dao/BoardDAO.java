package com.mvc.bbs.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.mvc.bbs.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list();
	
	int write(HashMap<String, String> params);

	void upHit(String idx);
	
	BoardDTO detail(String idx);

	int delete(String idx);

	int update(HashMap<String, String> params);

}
