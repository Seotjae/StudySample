package chap06.exam06.inherit;

import chap06.exam03.inter.MouseEvent;
import chap06.exam04.impl.KeyEvent;
//인터페이스에서는 오버라이드 할 필요가 없으므로 아무것도 나타나지 않음
public interface Child extends KeyEvent, MouseEvent {
	
	public void textField(String content);
	
	public void selectOne();
	
	public void checkOne();
	
}
