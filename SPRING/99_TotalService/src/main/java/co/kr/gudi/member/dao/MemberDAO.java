package co.kr.gudi.member.dao;

import co.kr.gudi.member.dto.MemberDTO;

public interface MemberDAO {

	String overlay(String id);

	int join(MemberDTO dto);

	String login(String id);
	

}
