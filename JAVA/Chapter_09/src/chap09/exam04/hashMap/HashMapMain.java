package chap09.exam04.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		
		//HashMap은 Map 인터페이스를 구현 받았으므로 이 안에 들어간다. -> 다형성
		Map<String, Integer> map = new HashMap<String, Integer>();
		//Map의 특징
		//1. 키와 값으로 구성된다 -> Key-Value Store
		//2. 순서가 없다 -> 기본적으로 a,b,c 순서로 맞춰주지만 100% 아님
		//3. 키의 중복을 허용하지 않는다 -> 키가 중복되면 값을 덮어씌움 (Set과의 차이)
		
		//데이터 넣기 add()가 아니고 put()으로 넣는다
		map.put("kim", 23); //이름, 나이 - 키와 값을 한 쌍으로 넣어야한다 -> 키를 통해서 값을 가져오기 때문에 반드시 키가 있어야 한다, 일단은 키는 무조건 문자열로 되어야 한다고 생각하자(복잡하다)
		map.put("lee", 26);
		map.put("park", 26); //값의 중복은 상관 없다
		map.put("kim", 30); //키의 중복은 허용하지 않는다 (나중 값으로 덮어 씌운다)
		
		//크기 알아보기
		System.out.println("map의 크기: " + map.size());
		
		//단일값 호출하기
		System.out.println(map.get("kim")); //map은 검색 시 key를 활용한다.
		
		//값 삭제하기
		System.out.println("방금 지운 값: " + map.remove("lee"));
		
		//map에서 하나씩 꺼내오기가 가장 중요 -> 쉽지 않음
		//하나씩 뽑아보기 (3가지 방식) -> set은 두가지
		//1. 키를 가져와서 값을 찾아내는 방식 (map에서 set형태로 키만 가져온다 -> iterator로 키를 쪼갠다 -> 키를 하나씩 가져와 맵에서 값을 찾는다)
		Set<String> keySet = map.keySet(); //맵에서 키 덩어리를 뽑아서 셋에 담는다
		Iterator<String> iter = keySet.iterator(); // 뽑아온 키 덩어리를 iterator로 쪼갠다
		while (iter.hasNext()) { 
			String key = iter.next(); //쪼갠 키를 가져와서
			int value = map.get(key); //맵에서 값을 찾는다
			System.out.println(key + ":" + value);
		}
		
		//2. map을 Entry set으로 만든다 -> iterator로 key와 value를 entry로 자른다 -> 자른 쌍에서 키와 값을 추출
		Set<Entry<String, Integer>> entrySet = map.entrySet(); //Map을 Entry로 Set에 가져온다
		Iterator<Entry<String, Integer>> entry = entrySet.iterator(); //가져온 Set에 Entry를 하나하나 꺼낼 수 있게 Iterator로 자른다
		while (entry.hasNext()) {
			Entry<String, Integer> item = entry.next(); //자른 Entry를 꺼내오고
			String key = item.getKey(); //꺼내온 Entry에서 key를 뽑아내고
			int value = item.getValue(); //value를 뽑아낸다
			System.out.println(key + ":" + value);
		}
		
		//3. 향상된 for문 (set을 iterator 없이 하나씩 가져올 수 있다)
		for (String key : map.keySet()) {//맵에서 키를 뽑아서 셋에 담고 향상된 for문으로 key값 추출 -> iterator 과정 생략 가능
			System.out.println(key + ":" + map.get(key)); //추출한 키로 값 추출
		}
		
		
		
	}

}
