package chap04.ex11.constant;

public class Person {
	
	//static final 규칙
	//1. static final은 불변의 값을 의미한다.
	//2. static final은 모두 대문자로 표시한다. //upper, lower case: ctrl + shift + x(대문자) or y(소문자)
	//3. 우리는 static final을 불변의 값 "상수" 라고 부른다.
	static final String NAME = "최성재";
	static final String SSN = "941017-1234567";
	static final String GENDER;
	
	static {//static block 으로 초기화 되긴 하나 의미가 없다.
		GENDER = "남자";
		
		
	}
	
	
}
