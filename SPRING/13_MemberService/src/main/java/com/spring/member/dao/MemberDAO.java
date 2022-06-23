package com.spring.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring.member.dto.MemberDTO;

public interface MemberDAO {

	int login(String id, String pw);

	ArrayList<MemberDTO> list();

	int join(MemberDTO dto);

	int join_map(HashMap<String, String> params);

	ArrayList<MemberDTO> search(HashMap<String, String> params);

	int update(HashMap<String, String> params);

	ArrayList<MemberDTO> multi(ArrayList<String> name);

}
