package spring.ajax.paging.dao;

import java.util.ArrayList;

import spring.ajax.paging.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list(int pagePerCnt, int offset);

	int allCount();

}
