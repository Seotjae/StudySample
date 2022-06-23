package com.photo.bbs.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.photo.bbs.dao.PhotoBoardDAO;
import com.photo.bbs.dto.BoardDTO;
import com.photo.bbs.dto.PhotoDTO;

@Service
public class PhotoBoardService {
	
	@Autowired PhotoBoardDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ArrayList<BoardDTO> list() {
		logger.info("요청된 list");
		return dao.list();
	}

	public BoardDTO detail(String idx) {
		logger.info("요청된 detail : {}", idx);
		int result=dao.upHit(idx);
		BoardDTO dto = null;
		if (result>0) {
			dto = dao.detail(idx);
		}
		return dto;
	}

	public String write(MultipartFile[] photos, HashMap<String, String> params) {
		logger.info("요청된 write : {}", params);
		logger.info("요청된 photos : {}", photos);
		String page = "redirect:/";
		BoardDTO dto =new BoardDTO();
		dto.setSubject(params.get("subject"));
		dto.setUser_name(params.get("user_name"));
		dto.setContent(params.get("content"));
		dao.write(dto);
		int idx=dto.getIdx();
		logger.info("가져온 Idx : "+idx);
		if (idx>0) {
			page = "redirect:/detail?idx="+idx;
			photosUpload(idx,photos);
		}	
		return page;
	}

	private void photosUpload(int idx, MultipartFile[] photos) {
		logger.info("요청된 photosUpload : {}",photos);
		for (MultipartFile photo : photos) {
			try {
				String oriFileName= photo.getOriginalFilename();
				int index = oriFileName.lastIndexOf(".");
				logger.info("확장자 : "+index);
				if (index>0) {
					String ext = oriFileName.substring(index);
					String newFileName = System.currentTimeMillis()+ext;
					byte[] bytes = photo.getBytes();
					Path path = Paths.get("C:/upload/"+newFileName);
					Files.write(path, bytes);
					dao.photosUpload(idx,oriFileName,newFileName);
					Thread.sleep(1);					
				}
			} catch (Exception e) {
				e.toString();
				e.printStackTrace();
			}
			
		}
		
	}

	public ArrayList<PhotoDTO> photolist(String idx) {
		logger.info("요청된 photolist : "+idx);
		return dao.photolist(idx);
	}

}
