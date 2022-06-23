package chap02.ex02.two;

public class Sub {

	public static void main(String[] args) {
		//result에 10을 대입
		//result에 10을 추가 하기
		int result = 10;
		result += 10; // = result + 10;
		System.out.println(result);
		
		//응용
		//1. 1~5 까지 더하기
		int num = 1;
		num += 2;
		num += 3;
		num += 4;
		num += 5;
		System.out.println(num);
		
		//2. 다음 값을 하나로 합치기 
		String str = "대입 연산자는";
		str += "합한 값을";
		str += "누적하는데";
		str += "아주 유용하다";
		System.out.println(str);
		
		
	}

}
