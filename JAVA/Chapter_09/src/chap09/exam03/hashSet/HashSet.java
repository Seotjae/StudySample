package chap09.exam03.hashSet;

import java.util.Iterator;
import java.util.Set;

public class HashSet {

	public static void main(String[] args) {
		
		//동일명의 클래스가 있으면 객체화시 풀 경로로 제공된다. (웬만하면 자주 사용되는 이름은 필할 것)
		Set<String> set = new java.util.HashSet<String>();
		Set<Member> member = new java.util.HashSet<Member>();
		
		//데이터 추가 (중복이면 받지 않는다.)
		set.add("JAVA");
		set.add("JSP");
		set.add("MARIADB");
		set.add("SPRING");
		set.add("JAVA");
		System.out.println(set.size()); //한개가 중복이라 4개만 받음
		
		//클래스는 객체화 될 때마다 각각 다른것으로 인정 한다. -> String 도 마찬가지 
		member.add(new Member());
		member.add(new Member());
		System.out.println(member.size()); //각각 다른 객체이기 때문에 2개
		
		//하나씩 뽑아내기
		Iterator<String> iter = set.iterator();//1.Set 이라는 덩어리를 하나씩 꺼낼 수 있도록 조각낸다.
		while(iter.hasNext()) { //2. 값이 있는지 확인한다. -> 꺼낼 값이 있으면 true, while은 조건이 true면 계속 반복 
			String item = iter.next(); //3. next를 이용해서 하나씩 꺼내온다.
			System.out.println(item);
		
		}
		
		//특정 요소 삭제
		set.remove("MARIADB");
		
		//하나씩 뽑아내기 한방에 해결
		for (String item : set) { //향상된 for문을 사용하면 set에서 Iterator()를 사용하지 않아도 된다.
			System.out.println(item);
		}
		System.out.println();
		
		//set이 비워져 있지 않으면 비우기
		System.out.println(set.size());
		if(!set.isEmpty()) { //set.isEmpty == false, set.size()>0
			System.out.println("비우기");
			set.clear();
		}
		System.out.println(set.size());
		
		
		
		
	}

}
