package chap10.exam05.sync;

public class User2 extends Thread {
	
	private Computer com;
	
	public User2(Computer com) {
		this.com = com;
		setName("User2");
	}

	@Override
	public void run() {
		com.setScore(100);
	}

}
