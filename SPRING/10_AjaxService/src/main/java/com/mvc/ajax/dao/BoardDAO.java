package com.mvc.ajax.dao;

import java.util.ArrayList;

import com.mvc.ajax.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> listCall();

	int delete(String idx);

}
