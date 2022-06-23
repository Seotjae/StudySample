package kr.co.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.board.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list();

	BoardDTO detail(String idx);

	int write(HashMap<String, String> params);

	void plus(String idx);

	int del(String idx);

	int update(HashMap<String, String> params);


	ArrayList<HashMap<String, Object>> test(HashMap<String, Object> params);

	ArrayList<Integer> ptv();

}
