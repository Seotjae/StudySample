package chap05.exam02.callSeq;

public class Child extends Parent {

	public Child() {
		//2.부모클래스 생성자 실행
		super(); //부모(슈퍼)클래스 내용 실행(생성자와 마찬가지로 너무 당연한거라 생략)
		//3.그 다음 자식 클래스 내용 실행
		System.out.println("자식 생성자 호출");
		
	}

}
