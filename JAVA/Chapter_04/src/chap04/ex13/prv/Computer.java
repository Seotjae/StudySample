package chap04.ex13.prv;

public class Computer {
	
	private boolean power = false; //외부에서 사용 가능 (변경, 조회)
	private int panSpeed = 0; //외부에서 사용 가능 (변경, 조회)
	private int temp = 25; //내부에서 조절 (조회)
	
	//getter / setter는 필요에 따라 private 변수를 수정/조회 할 수 있도록 한다.
	
//	public boolean isPower() {
//		return power;
//	}
//	public void setPower(boolean power) {
//		this.power = power;
//	}
//	public int getPanSpeed() {
//		return panSpeed;
//	}
//	public void setPanSpeed(int panSpeed) {
//		this.panSpeed = panSpeed;
//	}
//	public int getTemp() {
//		return temp;
//	}

	public boolean getPower() { //power는 private 변수라 같은 클래스 밖에서 사용하지 못하므로 public getter를 사용해서 외부에서도 사용할 수 있는 메서드로 만듬
		return power;
	}
	
	public void setPower (boolean power) {
		this.power = power;
	}
	
	public void setPanSpeed(int speed) {
		this.panSpeed = speed;
		//temp 직접 건드리면 위험하므로
		//pan speed를 통해서 온도를 조절 하도록 했다.
		this.temp = 90-speed; 
	
	}
	
	public int getPanSpeed() {
		return this.panSpeed;
	}
	
	public int getTemp() { //외부에선 temp를 직접 건드릴 수 없다.
		return this.temp;
	}
}




