package chap07.exam02.overInter;

import chap07.exam02.overInter.Element.EventListener;

public class Main {

	public static void main(String[] args) {
		//특정 요소를 가져온다 (ex: 버튼)
		Element elem = new Element();
		
		//이벤트 리스너 등록
		EventListener listener = new OnclickListener();
		elem.regist(listener);
		elem.trigger();
		
		elem.regist(new OnkeyListener());
		elem.trigger();
		
		//이벤트 발생
		
		
	}

}
