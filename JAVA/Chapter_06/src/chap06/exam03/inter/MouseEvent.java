package chap06.exam03.inter;

public interface MouseEvent { 

	public void click(int btn); //몸체만 없으면 abstract 키워드 없이 추상메서드로 인식
	
	public void dblclick(int btn);
	
	public double[] move();
	
	public default void wheel(int i) {//인터페이스에서는 일반메서드를 만들때 default를 붙여야 한다. -> 아무것도 안붙인 메서드는 이미 추상 메서드로 사용하고 있기 때문에
		if (i == 1) {
			System.out.println("up scroll");
		}else {
			System.out.println("down scroll");
		}
	}
	
	public static void setDpi(int dpi) {
		System.out.println("set Dpi: " + dpi);
	}
	
	
}
