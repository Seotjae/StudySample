package chap09.exam01.arList;

import java.util.Vector;

public class ArrayList02 {

	//데이터 수정, 검색, 비우기
	public static void main(String[] args) {
		
		//Vector와 ArrayList는 List를 구현 받았기 때문에 사용법이 동일하다.
		//다만 Vector는 내가 이용할 때 다른 사용자가 접근하지 못하도록 한다. (Thread Safe)
		Vector<Integer> list = new Vector<Integer>();
		
		//add로 데이터 추가 6개
		list.add(70); //0
		list.add(80); //1
		list.add(50); //2
		list.add(90); //3
		list.add(100); //4
		list.add(90); //5
		
		//set : 특정 인덱스의 데이터를 수정
		System.out.println(list.set(3, 95)); //수정 전 값을 보여준다.
		
		//검색
		//contains : 특정 값이 리스트에 포함되어 있는지 boolean으로
		System.out.println("30 이라는 값이 존재하는가? " + list.contains(30));
		//indexOf : 특정 값이 리스트의 몇번 인덱스에 존재하는지 int로 (없으면 -1)
		System.out.println("90 이라는 값은 몇번 인덱스에 존재하는가? " + list.indexOf(90));
		
		//비우기
		list.clear();
		System.out.println(list.size()); //확인법 1: 안의 개수를 확인
		System.out.println(list.isEmpty()); //확인법 2: 비어있는가 확인 -> is는 상태를 물어보는 것
		

		
		
		
	}

}
