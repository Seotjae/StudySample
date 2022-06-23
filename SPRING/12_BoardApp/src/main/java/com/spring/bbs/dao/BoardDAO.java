package com.spring.bbs.dao;

import java.util.ArrayList;

import com.spring.bbs.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list();

	BoardDTO detail(String idx);

	void upHit(String idx);

	void delete(String idx);

	void write(BoardDTO dto);

}
