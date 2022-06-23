package chap06.exam06.inherit;

//인터페이스는 다중 상속이 가능해서 규격들을 가져와서 새로운 규격을 짤 수 있다.
//Child 하나 구현 받았는데... MouseEvent, KeyEvent, Child의 모든 추상 메서드들을 오버라이드 했다.
//기존 규격에 새로운 규격이 추가되었을 때 기존 규격을 상속받은 새로운 규격 인터페이스를 작성하면 된다.
public class ChildImple implements Child {

	@Override
	public void keyDown(int key) {

	}

	@Override
	public void keyUp(int key) {

	}

	@Override
	public void click(int btn) {

	}

	@Override
	public void dblclick(int btn) {

	}

	@Override
	public double[] move() {
		return null;
	}

	@Override
	public void textField(String content) {

	}

	@Override
	public void selectOne() {

	}

	@Override
	public void checkOne() {

	}

}
