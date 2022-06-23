package com.spring.board.dao;

import java.util.ArrayList;

import com.spring.board.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list();

	void upHit(String idx);

	BoardDTO detail(String idx);

}
