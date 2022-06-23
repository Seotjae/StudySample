package chap07.exam03.overInter;
/*
	인터페이스가 따로 빠져나와 있는 경우는 공통의 EventListener(규격)가 되지만
	특정 Element 안에 존재하면 해당 Element 만의 EventListener(규격)로 인식된다.
	소스를 보는 사람의 인식의 차이를 만들기 위해서 사용
	
	중첩을 사용 시 -> 각 클래스별 규격을 정할 때, 단점으로 중복이 발생 할 수 있다.
	사용하지 않을 경우 (일반적인 경우) -> 전체 규격중에서 해당하는 것을 가져온다, 단점은 규격이 너무 많으면 골라오기가 어렵다.
*/
public class Element {
	
	//실선: 호출하는 메서드가 끝나도 객체가 남아있는 경우
	EventListener listener;
	
	void regist(EventListener listener) {
		this.listener = listener;
	}
	
	void trigger() {
		listener.call();
	}

	
}
