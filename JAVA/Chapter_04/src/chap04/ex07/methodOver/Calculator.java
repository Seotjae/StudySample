package chap04.ex07.methodOver;

public class Calculator {

	//두가지를 더하는 메서드를 만들자
//	int Cal(int a, int b) {
//		return a+b;
//	}
//	
//	String Cal(String a, String b) {
//		return a+b;
//	}
//	
//	double Cal(double a, double b) {
//		return a+b;
//	}
//	
//	char Cal(char a, char b) {
//		return (char) (a+b);
//	}
	
	public int plus(int i, int j) {
		return i+j;
	}
	
	public String plus(String s, int j) {
		return s+j;
	}
	
	public double plus(int i, double d) {
		return i+d;
	}
	
	public String plus(String s1, String s2) {
		return s1+s2;
	}
	
	
	
}//
