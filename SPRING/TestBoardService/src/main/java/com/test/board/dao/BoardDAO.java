package com.test.board.dao;

import java.util.ArrayList;

import com.test.board.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list();

	int write(BoardDTO dto);

	BoardDTO detail(String idx);

	void upHit(String idx);

	void delete(String idx);

}
