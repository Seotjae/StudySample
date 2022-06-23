package co.kr.gudi.bbs.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.gudi.bbs.dao.BoardDAO;
import co.kr.gudi.bbs.dto.BoardDTO;

@Service
public class BoardService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired BoardDAO boardDAO;

	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		ArrayList<BoardDTO> list = boardDAO.list();
		logger.info("리스트 수 : {}",list.size());
		mav.addObject("list",list);
		return mav;
	}
	
	@Transactional
	public ModelAndView detail(String idx) {
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("detail");
		 boardDAO.upHit(idx);
		 BoardDTO dto = boardDAO.detail(idx);
		 mav.addObject("bbs",dto);
		return mav;
	}

	public ModelAndView del(String idx, RedirectAttributes rAttr) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list");
		
		String msg = "삭제에 실패 했습니다.";
		int result = boardDAO.del(idx);
		logger.info("삭제 성공 여부 : {}",result);
		if (result>0) {
			msg="삭제에 성공 했습니다.";
		}
		//mav.addObject("msg",msg);
		rAttr.addFlashAttribute("msg",msg);
		
		return mav;
	}

	public String write(BoardDTO dto) {
		logger.info("글쓰기 서비스 요청 : {}",dto.getSubject());
		boardDAO.write(dto);
		int idx = dto.getIdx();
		logger.info("작성된 글 번호 : {}",idx);
		return "redirect:/detail?idx="+idx;
	}

	public ModelAndView updateForm(String idx) {
		ModelAndView mav = new ModelAndView();
		BoardDTO dto= boardDAO.detail(idx);
		logger.info("가져온 글 제목 : {}",dto.getSubject());
		mav.addObject("bbs",dto);
		mav.setViewName("updateForm");
		return mav;
	}

	public ModelAndView update(BoardDTO dto) {
		String page = "redirect:/list";
		if (boardDAO.update(dto)>0) {
			page="redirect:/detail?idx="+dto.getIdx();
		}
		return new ModelAndView(page);
	}

}
