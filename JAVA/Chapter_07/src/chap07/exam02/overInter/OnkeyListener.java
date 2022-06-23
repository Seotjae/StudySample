package chap07.exam02.overInter;

import chap07.exam02.overInter.Element.EventListener;

public class OnkeyListener implements EventListener {

	@Override
	public void call() {
		System.out.println("키보드를 눌렀을 때 행동");
		
	}

}
