package kr.co.gudee.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudee.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(HttpSession session) {
		logger.info("Board list 요청");
		//session 에 loginId 가 있는지 확인
		/*if (session.getAttribute("loginId") == null) {
			logger.info("Board list 요청 : 로그인된 아이디 없음");
			return new ModelAndView("login");
		}*/
		return boardService.list();
	}
	
	@RequestMapping(value="/detail", method =  RequestMethod.GET)
	public ModelAndView detail(@RequestParam String idx, HttpSession session) {
		logger.info(idx+ "번 데이터 상세 정보 요청");
		//session 에 loginId 가 있는지 확인
		/*if (session.getAttribute("loginId") == null) {
			logger.info("Board detail 요청 : 로그인된 아이디 없음");
			return new ModelAndView("login");
		}*/
		return boardService.detail(idx);
	}
	
	@RequestMapping(value="/delete", method =  RequestMethod.GET)
	public ModelAndView delete(@RequestParam String idx, HttpSession session) {
		logger.info(idx+ "번 데이터 삭제 요청");
		//session 에 loginId 가 있는지 확인
		/*if (session.getAttribute("loginId") == null) {
			logger.info("Board detail 요청 : 로그인된 아이디 없음");
			return new ModelAndView("login");
		}*/
		return boardService.delete(idx);
	}
	
	
	

}
