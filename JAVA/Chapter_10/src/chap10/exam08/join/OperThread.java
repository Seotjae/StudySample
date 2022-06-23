package chap10.exam08.join;

public class OperThread extends Thread {
	
	private int sum;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			this.sum += i;
		}
	}
	
}
