package kr.co.gudee.board.dao;

import java.util.ArrayList;

import kr.co.gudee.board.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list();

	int upHit(String idx);

	BoardDTO detail(String idx);

	int delete(String idx);

}
