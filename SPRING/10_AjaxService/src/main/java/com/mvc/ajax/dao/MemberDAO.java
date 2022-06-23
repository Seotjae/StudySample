package com.mvc.ajax.dao;

import java.util.HashMap;

public interface MemberDAO {

	String overlay(String id);

	int join(HashMap<String, String> params);

	int login(String id, String pw);

	


}
