package chap07.exam02.overInter;

public class Element {
	
	EventListener listener;
	
	//특정 이벤트를 등록하는 역할
	void regist(EventListener listener) {
		this.listener = listener;
	}
	
	void trigger() {//이벤트 발생
		listener.call();
	}
	
	//이벤트 리스너는 특정한 사건을 감시하는 역할
	interface EventListener { //내부 인터페이스 (중첩)
		void call();
	}
	
}
