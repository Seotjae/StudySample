package kr.co.gudee.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudee.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired MemberService memberService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//로그인 성공시 list 로 실패시 다시 login 으로
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String id,@RequestParam String pw,HttpSession session) {
		logger.info("Member 로그인 요청 : {}/{}",id,pw);
		String loginId= memberService.login(id,pw);
		logger.info("로그인된 아이디 : {}",loginId);
		
		String page = "login";
		if (loginId != null) {
			session.setAttribute("loginId",loginId);
			page="redirect:/list";
		}

		return  new ModelAndView(page);
	}
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		
		session.removeAttribute("loginId");
		ModelAndView mav =  new ModelAndView("redirect:/");
		//redirect 로 화면 전한시 모델에 담은 데이터는 파라미터 형태로 전달된다
		//보안상 좋지 않아 사용을 권고하지 않는다
		mav.addObject("msg","로그아웃이 완료되었습니다. 다음에 봐요!");
		return  mav;
	}
	
	
	
	
	
	
	
	
	
}
