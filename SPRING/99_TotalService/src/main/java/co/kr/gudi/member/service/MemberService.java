package co.kr.gudi.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.kr.gudi.member.dao.MemberDAO;
import co.kr.gudi.member.dto.MemberDTO;

@Service
public class MemberService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberDAO memberDAO;

	public boolean overlay(String id) {
		logger.info("중복확인 서비스 요청 : {}",id);
		boolean overlay = true;
		String chkId = memberDAO.overlay(id);
		if (chkId == null) {
			overlay = false;
		}
		return overlay;
	}

	public int join(MemberDTO dto) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pw = dto.getPw();
		logger.info("plain pw : "+pw);
		String encPw = encoder.encode(pw);
		logger.info("enc pw : "+encPw);
		dto.setPw(encPw);
		return memberDAO.join(dto);
	}

	public boolean login(String id, String pw) {
		boolean result = false;
		//평문을 암호문과 비교하는 방법
		//1. 받아온 아이디와 일치하는 비밀번호를 DB에서 가져옴
		String getPW= memberDAO.login(id);
		logger.info("가져온 비밀번호 : {}",getPW);
		if (getPW != null) {
			//2. DB에서 가져온 비밀번호와 받아온 비밀번호를 encoder 를 사용해서 비교
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			result = encoder.matches(pw,getPW);		
			logger.info("일치 여부 : {}",result);	
		}
		return result;
	}




	
	
	
	
	
	
}
