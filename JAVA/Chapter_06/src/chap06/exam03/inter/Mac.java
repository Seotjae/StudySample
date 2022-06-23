package chap06.exam03.inter;

public class Mac implements MouseEvent {

	@Override
	public void click(int btn) {
		System.out.println(btn + "번 맥버튼 클릭");

	}

	@Override
	public void dblclick(int btn) {
		System.out.println(btn + "번 맥버튼 더블클릭");

	}

	@Override
	public double[] move() {
		return null;
	}

}
