package chap09.exam04.hashMap;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashTableMain {

	public static void main(String[] args) {
		Map<String, Integer> map = new Hashtable<String, Integer>();
		//이름, 점수
		map.put("김철호", 99);
		map.put("박동빈", 80);
		map.put("박은비", 75);
		map.put("신솔비", 43);
		map.put("한은정", 52);
		map.put("김민지", 100);
		map.put("김윤경", 80);
		map.put("정철수", 99);
		map.put("안은호", 87);
		map.put("최영일", 75);
		
		//검색해보기
		//해당 키가 포함되어 있는지 확인
		//map.containsKey(key);
		String name = "박은비";
		boolean key = map.containsKey(name);
		if (key == true) {
			System.out.println(name + " 이/가 존재합니다.");
		}else {
			System.out.println(name + " 이/가 존재하지 않습니다.");
		}
		
		
		//해당 값이 포함되어 있는지 확인
		//map.containsValue(Value);
		int score = 99;
		boolean value = map.containsValue(score);
		if (value == true) {
			System.out.println(score + "점을 맞은 학생이 존재합니다.");
		}else {
			System.out.println(score + "점을 맞은 학생이 존재하지 않습니다.");
		}
		
		//문제 1: 박은비의 점수는 몇점인가?
		name = "박은비";
		key = map.containsKey(name);
		if (key == true) {
			score = map.get(name);
			System.out.println(name + "의 점수는 " + score + "점 입니다.");
		}else {
			System.out.println(name + " 학생은 존재하지 않습니다.");
		}
		
		//문제 2: 99점 맞은 학생의 이름은? -> 한명이 아니다
		Set<Entry<String, Integer>> entrySet  = map.entrySet();
		Iterator<Entry<String, Integer>> entry = entrySet.iterator();
		while (entry.hasNext()) {
			Entry<String, Integer> item = entry.next();
			name = item.getKey();
			score = item.getValue();
			if (score == 99) {
				System.out.println(score + "점인 학생: " + name);
			}
		}
		 
		 for (String student : map.keySet()) {
			score = map.get(student);
			if (score == 75) {
				System.out.println(score + "점인 학생: " + student);
			}
		}
	}

}
