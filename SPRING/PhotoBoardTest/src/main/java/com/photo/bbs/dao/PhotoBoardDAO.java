package com.photo.bbs.dao;

import java.util.ArrayList;

import com.photo.bbs.dto.BoardDTO;
import com.photo.bbs.dto.PhotoDTO;

public interface PhotoBoardDAO {

	ArrayList<BoardDTO> list();

	BoardDTO detail(String idx);

	void write(BoardDTO dto);

	int upHit(String idx);

	void photosUpload(int idx, String oriFileName, String newFileName);

	ArrayList<PhotoDTO> photolist(String idx);

	
}
