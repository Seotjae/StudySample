package kr.co.gudee.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	
	
	//컨트롤러에 들어가기 전에 거치는 메서드
	//반환값이 true 면 해당 컨트롤러에 갈 수 있지만, false 면 그 자리에서 멈추게 된다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("PRE HANDLER PASS");
		HttpSession session = request.getSession(); //세션 추출
		
		boolean pass = true;
		
		if (session.getAttribute("loginId") == null) { //session에 loginId 값이 있는지?
			//loginId 값이 없으면 로그인하지 않은 유저로 간주해서 컨트롤러 진입을 막는다
			pass= false;
			//response.sendredirect 는 context 경로도 포함해야한다.
			response.sendRedirect("/gudee/");
		}
		
		return pass;
	}
	
	//컨트롤러를 지난 다음 거치게 되는 메서드
	//보통 ModelAndView 에 원하는 값을 추가할 때 사용한다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		System.out.println("POST HANDLER PASS");
		
		HttpSession session = request.getSession();
		
		String content = "안녕하세요"+session.getAttribute("loginId")+"님 <a href='logout'>로그아웃</a>";
		mav.addObject("loginBox",content); //이 값이 view 로 전송된다
	}

	
	
}
