package chap04.ex08.sMember;

public class Main {

	public static void main(String[] args) {
		
		//사용하기 위해서 객체화(복사)
		Sub sub = new Sub(); //Sub 클래스 객체화
		
		int result = sub.multi(3, 4); //객체화된 multi 메서드를 호출
		System.out.println(result);
		
		//static 영역에 있는 member 사용
		//원본 클래스에 직접가서 가져온다.
		System.out.println("static field: " + Sub.sField); //sField 변수는 static이 붙어 있기 때문에 객체화 되지 않았고 Sub 클래스에 가서 직접 호출해옴.
		
		result = Sub.plus(1, 2);
		System.out.println(result);
		
		result = Sub.minus(10, 2);
		System.out.println(result);
		
		//실수가 너무 많다보니 연결은 해주는데 쓰지말라고 경고!
		//직접가면 될걸 복사본을 거쳐서 가다보니 효율성이 좋지 않음
		System.out.println(sub.sField); //객체화된 sField 변수를 불러온 오류이지만 이클립스가 알아서 수정해줌
		
		
	}

}
