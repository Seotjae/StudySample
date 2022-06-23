package com.test.member.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.member.dto.MemberDTO;
import com.test.member.service.MemberService;


@Controller
public class HomeController {
	
	@Autowired MemberService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("로그인 페이지 이동");
		return "login";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {
		logger.info("회원가입 페이지 이동");
		return "joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, @RequestParam HashMap<String, String> params) {
		int result = service.join(params);
		String page = "joinForm";
		if (result>0) {
			page="login";
		}
		return page;
	}	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam String id, @RequestParam String pw, HttpSession session) {
		logger.info("로그인 요청");
		String loginId= service.login(id, pw);
		String page = "login";
		logger.info("로그인 한 아이디 : "+loginId);
		if (loginId != null) {
			session.setAttribute("loginId", loginId);
			page="redirect:/list";
		}
		return page;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		logger.info("리스트 페이지 이동");
		String page = "redirect:/";
		if (session.getAttribute("loginId") != null) {
			page = "list";
			ArrayList<MemberDTO> list = service.list();
			logger.info("가져온 리스트 : {}",list);
			model.addAttribute("list",list);
		}
		return page;
	}

	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Model model, HttpSession session, @RequestParam String id) {
		logger.info("삭제 요청");
		String page = "login";
		if (session.getAttribute("loginId") != null) {
			int result = service.del(id);
			logger.info("삭제 결과 : "+result);
			page = "redirect:/list";
		}
		return page;
	}	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,HttpSession session,@RequestParam String id) {
		logger.info("상세보기 이동");
		String page="login";
		if (session.getAttribute("loginId") != null) {
			page="detail";
			MemberDTO detail= service.detail(id);
			logger.info("가져온 상세보기 : " + detail);
			model.addAttribute("detail",detail);
		}
		return page;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model, @RequestParam HashMap<String, String> params,HttpSession session) {
		logger.info("업데이트 요청");
		String page = "login";
		if (session.getAttribute("loginId") != null) {
			page="redirect:/detail?id="+params.get("id");
			int result = service.update(params);
			logger.info("업데이트 결과 : "+result);
		}
		return page;
	}	
	
	
	
}
