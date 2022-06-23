package chap07.exam02.overInter;

import chap07.exam02.overInter.Element.EventListener;

public class OnclickListener implements EventListener {

	@Override
	public void call() {
		System.out.println("클릭했을 때 발생할 행동");
		
	}

}
