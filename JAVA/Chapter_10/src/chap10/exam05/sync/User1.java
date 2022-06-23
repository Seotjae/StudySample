package chap10.exam05.sync;

public class User1 extends Thread {
	
	private Computer com;
	
	public User1(Computer com) {
		this.com = com;
		setName("User1");
	}

	@Override
	public void run() {
		com.setScore(500);
	}
	
}
