package com.spring.main.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface TeamDAO {

	ArrayList<HashMap<String, String>> list();

	int update(String col, String val, String pk);

}
