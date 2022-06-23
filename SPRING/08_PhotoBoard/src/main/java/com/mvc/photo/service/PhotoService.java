package com.mvc.photo.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.mvc.photo.dao.PhotoDAO;
import com.mvc.photo.dto.BoardDTO;
import com.mvc.photo.dto.PhotoDTO;

@Service
public class PhotoService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired PhotoDAO dao;

	public ArrayList<BoardDTO> list() {
		return dao.list();
	}

	public BoardDTO detail(String idx) {
		
		BoardDTO dto = null;
		int success= dao.upHit(idx);
		if (success>0) {
			dto = dao.detail(idx);			
		}
		return dto;
	}

	public String write(MultipartFile[] photos, HashMap<String, String> params) {
		
		String page = "redirect:/"; //반환할 기본 경로 설정
		//우리는 방금 insert 한 글의 idx 번호를 알아내야 한다 (중요)
		//1) 성공하면 특정 상세보기로 넘어갈 때 글 번호가 필요해서
		//2) 파일을 업로드한 경우 photo 테이블에 글 번호를 넣어야하기 때문에
		
		//방금 넣은 데이터에 대한 idx를 알고 싶다면 몇가지 조건이 있다
		//조건1 파라메터는 DTO 형태로 넣을 것
		BoardDTO dto = new BoardDTO(); //방 금 넣은 데이터의 idx 를 반환 받기 위한 DTO 객체화
		dto.setSubject(params.get("subject")); //객체화 한 dto 에 파라메터를 넣는다
		dto.setUser_name(params.get("user_name"));
		dto.setContent(params.get("content"));
		dao.write(dto); //dao 에 파라메터가 담긴 dto를 넘기고 write 메서드 실행
		//이렇게 실행하고 나면 dto 에 방금 넣은 게시글에 대한 idx 가 담겨져 나온다
		int idx = dto.getIdx(); //write 메서드를 실행하면서 dto 에 담긴 idx 를 가져옴
		logger.info("idx : "+idx);
		if (idx>0) { //idx를 가져왔다면
			page = "redirect:/detail?idx="+idx; //가져온 idx 에 해당하는 detail 요청을 보내는 경로 설정
			saveFile(idx,photos);//파일 저장 처리 //idx와 업로드한 파일을 넘기고 파일을 저장하는 메서드를 실행
		}
		return page;
	}
	
	//파일 저장 (실제 파일을 저장하고 경로를 DB 에 기록)
	private void saveFile(int idx, MultipartFile[] photos) {
		for (MultipartFile photo : photos) {
			
			try {
				String oriFileName = photo.getOriginalFilename();
				int index = oriFileName.lastIndexOf(".");
				logger.info("index : {}",index);
				
				//방어코드 : 예외 발생이 예상되는 지점을 피해가도록 처리
				if (index>0) {
					String ext = oriFileName.substring(index);
					String newFileName = System.currentTimeMillis()+ext; 
					logger.info(oriFileName+" => "+newFileName );
					byte[] bytes = photo.getBytes();
					Path path = Paths.get("C:/upload/"+newFileName);
					Files.write(path, bytes);
					logger.info(oriFileName+"Save Ok");
					dao.fileWrite(idx,oriFileName,newFileName);					
				}				
				Thread.sleep(1);
			} catch (Exception e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}
		}
	}

	public ArrayList<PhotoDTO> photoList(String idx) {
		return dao.photoList(idx);
	}

	public void delete(String idx) {
		
		ArrayList<PhotoDTO> list = dao.photoList(idx); //1.게시물에 사진이 있는지 확인
		int success = dao.delete(idx); //2. 게시물 삭제
		if (success>0) { //3. 삭제가 완료되면 C:/upload/ 에 해당 파일 삭제 (newFileName)
			for (PhotoDTO dto : list) { //4. 있으면 업로드 된 사진 이름(newFileName) 알아오기
				File file = new File("C:/upload/"+dto.getNewFileName());
				boolean yn = file.delete();
				logger.info(dto.getNewFileName()+"delete : "+yn);
			}
			
		}
		
	}

	public String updateForm(Model model, String idx) {
		logger.info("updateForm service 동작");
		BoardDTO dto = dao.detail(idx);
		ArrayList<PhotoDTO> list = dao.photoList(idx);
		
		logger.info("subject : "+dto.getSubject());
		logger.info("photos : {}",list);
		
		model.addAttribute("dto",dto);
		model.addAttribute("photos",list);
		return "updateForm";
	}

	public String update(MultipartFile[] photos, HashMap<String, String> params) {
		int idx = Integer.parseInt(params.get("idx"));
		logger.info("idx : "+idx);
		String page = "redirect:/updateForm?idx="+idx; 
		
		if (dao.update(params)>0) {
			page = "redirect:/detail?idx="+idx;
			saveFile(idx,photos);
		}
		return page;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
