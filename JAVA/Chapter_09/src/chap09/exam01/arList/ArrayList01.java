package chap09.exam01.arList;

import java.util.ArrayList;

public class ArrayList01 {

	//ArrayList 선언, 기본입력, 삭제, 출력
	public static void main(String[] args) {
		
		//크기 지정도 가능하나, 안해도 상관없다.
		ArrayList<String> list = new ArrayList<String>(3);
		
		//데이터 추가
		list.add("collection"); //0
		list.add("thread"); //1
		list.add("java io"); //2
		list.add("network"); //3 -> 배열이라면 ArrayIndexOutOfBoundException 발생
		list.add(3, "TEST"); //3번 인덱스에 넣겠다. (이 경우 기존에 있었던 값들이 뒤로 밀린다.)
		
		//출력
		//list.size()를 사용하면 크기를 알 수 있다.
		//System.out.println(list.size());
		//list.get(index)를 사용하면 해당 index의 값을 꺼내온다.
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println("list[" + i + "] = " + str);
		}
		System.out.println();
		
		//데이터 삭제
		String result = list.remove(2);	//index를 지정해서 지울 경우 어떤 값이 지워졌는지 알려준다.
		System.out.println(result); 
		boolean result2 = list.remove("collection"); //값을 지정해서 지울 경우 성공 여부를 알려준다.
		System.out.println(result2 + "\n");
		
		//출력2
		for (String item : list) {
			System.out.println(item);
		}
		
		
		
	}

}
