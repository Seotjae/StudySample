package chap11.exam09.buffer;

public class TimeChecker {
	
	long start = 0;
	long end = 0;
	
	public void timeStart() {
		start = System.currentTimeMillis();
	}
	
	public long timeStop() {
		end = System.currentTimeMillis();
		return end - start;
	}
}
