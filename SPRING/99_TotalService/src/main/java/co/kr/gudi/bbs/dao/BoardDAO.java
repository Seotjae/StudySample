package co.kr.gudi.bbs.dao;

import java.util.ArrayList;

import co.kr.gudi.bbs.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list();

	void upHit(String idx);

	BoardDTO detail(String idx);

	int del(String idx);

	void write(BoardDTO dto);

	int update(BoardDTO dto);

}
