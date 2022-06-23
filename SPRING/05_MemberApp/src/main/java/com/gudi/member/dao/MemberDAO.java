package com.gudi.member.dao;

import java.util.ArrayList;

import com.gudi.member.dto.MemberDTO;

public interface MemberDAO {

	int join(String id, String pw, String name, String age, String gender, String email);

	String login(String id, String pw);

	ArrayList<MemberDTO> list();

	int del(String id);

	MemberDTO detail(String id);

	int update(String id, String pw, String name, String age, String gender, String email);




}
