package chap10.exam05.sync;

public class PcRoom {

	public static void main(String[] args) {
		
		Computer com = new Computer();
		
		User1 user1 = new User1(com);
		user1.start();
		
		User2 user2 = new User2(com);
		user2.start();
		
	}

}
