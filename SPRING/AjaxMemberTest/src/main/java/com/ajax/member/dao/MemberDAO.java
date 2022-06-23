package com.ajax.member.dao;

import java.util.HashMap;

public interface MemberDAO {

	int overlay(String id);

	int regist(HashMap<String, String> params);

	int login(String id, String pw);

}
