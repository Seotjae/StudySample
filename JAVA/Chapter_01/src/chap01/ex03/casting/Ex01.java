package chap01.ex03.casting;

public class Ex01 {

	public static void main(String[] args) {
		/*묵시적 형변환(작은변수 -> 큰변수)*/
		byte byteValue;
		char charValue;
		int intValue;
		long longValue;
		float floatValue;
		double doubleValue;
		
		//byte < int
		byteValue = 10;
		intValue = byteValue;
		
		//char < int
		charValue = 'A';
		intValue = charValue;
		System.out.println(intValue); //아스키코드(유니코드)
		
		
		//int < long
		longValue = intValue;
		
		//float < double
		floatValue = 0.1f;
		doubleValue = floatValue;
		
		

	}

}
