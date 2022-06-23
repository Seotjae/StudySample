package chap02.ex01.one;

public class One {

	public static void main(String[] args) {
		
		//단항 연산자
		//1. 증감 연산자
		int x = 10;
		int y = 10;
		
		x++;//증가 나중, 행동하고 나서 카운트
		++y;//증가 먼저, 카운트하고 나서 행동
		
		System.out.println("x++: " + x);
		System.out.println("++y: " + y);
		
		x=1;
		y=1;

		int result = (++x) + 10; //x가 1에서 증가하여 2가 됨 -> 10과 더해짐
		int result2 = (y++)	+ 10; //y가 10과 더해짐 -> y가 1에서 2로 증가
		
		//++가 뒤에 붙으면 무언가 행해지고 난 다음에 카운트 할 떄 사용 된다.
		
		System.out.println("result: " + result);
		System.out.println("result2: " + result2);
		
		
		
		//2. 논리부정 연산자
		boolean yn = true;
		System.out.println("yn의 값: " + yn);
		yn = !yn;
		System.out.println("!yn의 값: " + yn);
		yn = !yn;
		System.out.println("!yn의 값: " + yn);
		

	}

}
