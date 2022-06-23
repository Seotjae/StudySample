package com.mvc.photo.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.mvc.photo.dto.BoardDTO;
import com.mvc.photo.dto.PhotoDTO;

public interface PhotoDAO {

	ArrayList<BoardDTO> list();

	BoardDTO detail(String idx); //상세정보 가져오기

	int upHit(String idx); //조회수 올리기

	void write(BoardDTO dto);

	void fileWrite(int idx, String oriFileName, String newFileName);

	ArrayList<PhotoDTO> photoList(String idx);

	int delete(String idx);

	int update(HashMap<String, String> params);

}
