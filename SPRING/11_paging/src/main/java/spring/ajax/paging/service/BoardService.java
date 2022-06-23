package spring.ajax.paging.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.ajax.paging.dao.BoardDAO;
import spring.ajax.paging.dto.BoardDTO;

@Service
public class BoardService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardDAO dao;

	public HashMap<String, Object> list(int currPage, int pagePerCnt) {
		logger.info("리스트 서비스 요청");
		
		int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; //어디서부터 보여줘야 하는가?
		logger.info("offset : {}",offset);
		
		int totalCount = dao.allCount(); //bbs 테이블의 모든 데이터의 개수
		int range = totalCount%pagePerCnt > 0 ? (totalCount/pagePerCnt)+1 : totalCount/pagePerCnt;
		logger.info("총 개수 : {}",totalCount);
		logger.info("만들 수 있는 총 페이지 : {}",range);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pages", range);
		ArrayList<BoardDTO> list= dao.list(pagePerCnt,offset);
		logger.info("가져온 리스트 : {}",list.size());
		map.put("list", list);
		return map;
	}

}
