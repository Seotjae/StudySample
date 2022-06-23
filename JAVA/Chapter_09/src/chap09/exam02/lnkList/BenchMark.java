package chap09.exam02.lnkList;

import java.util.ArrayList;
import java.util.LinkedList;

public class BenchMark {

	public static void main(String[] args) {
		//A와 B의 달리기 측정
		//A 준비 -> 출발 , 시간측정 -> 도착, 시간측정 -> 도착시간 - 출발시간 = 걸린시간
		//B 준비 -> 출발 , 시간측정 -> 도착, 시간측정 -> 도착시간 - 출발시간 = 걸린시간
		//A와 B의 비교
		ArrayList<String> arr = new ArrayList<String>(); //1. ArrayList 준비
		for (int i = 1; i <= 100; i++) { //2. 데이터 넣기
			arr.add("data");
		}
		
		long startTime = System.currentTimeMillis(); //3. 시간 확인
		
		for (int i = 1; i < 500000; i++) { //4. ArrayList 중간에 데이터 넣기
			arr.add(50, "add data");
		}
	
		long endTime = System.currentTimeMillis(); //5. 데이터 넣기가 끝나면 시간 확인
		
		System.out.println("ArrayList 걸린 시간: " + (endTime - startTime) + "ms"); //6. 도착시간 - 출발시간 = 걸린시간
		
		
	
		
		LinkedList<String> link = new LinkedList<String>(); //1. LinkedList 준비
		for (int i = 1; i <= 100; i++) { //2. 데이터 넣기
			link.add("data");
		} 
		startTime = System.currentTimeMillis(); //3. 시간 확인
		
		for (int i = 1; i < 500000; i++) { //4. LinkedList 중간에 데이터 넣기
			link.add(50, "add data");
		}
		endTime = System.currentTimeMillis(); //5. 데이터 넣기가 끝나면 시간 확인
		
		System.out.println("linkedList 걸린 시간: " + (endTime - startTime) + "ms"); //6. 도착시간 - 출발시간 = 걸린시간		
		
		
	}

}
