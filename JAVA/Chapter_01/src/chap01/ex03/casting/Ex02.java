package chap01.ex03.casting;

public class Ex02 {

	public static void main(String[] args) {
		//명시적 형변환(작은 변수 -> 큰 변수)
		//해주지 않을 경우 오류가 발생(이클립스에서 해결 가능)
		char charValue;
		int intValue;
		long longValue;
		float floatValue;
		double doubleValue;
		
		//int > char
		intValue = 44032;
		charValue = (char) intValue;
		System.out.println(charValue);
		
		//int < long
		longValue = 500;
		intValue = (int) longValue;
		
		//float < double
		doubleValue = 3.14;
		floatValue = (float) doubleValue;

	}

}
