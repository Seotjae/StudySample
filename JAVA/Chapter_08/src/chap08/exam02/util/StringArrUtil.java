package chap08.exam02.util;

public class StringArrUtil {

	public static void main(String[] args) {
		
		String string = "abcdefg";
		String stringResult;
		int intResult;
		char charResult;
		
		//문자열은 캐릭터 배열임을 생각해서 만든 메서드
		//1. 문자열의 길이
		intResult  = string.length();
		System.out.println("string의 길이: " + intResult);
		
		//2. 특정 인덱스의 문자 가져오기
		charResult = string.charAt(3);
		System.out.println("3번 인덱스에 있는 문자: " + charResult);
		
		//3. 잘라내기 (중요)
		stringResult = string.substring(1, 5); //1번 인덱스부터 보여줘, 5번 인덱스부터 잘라라
		System.out.println(stringResult); //bcde
		
		//4. 문자열 -> 캐릭터 배열
		char[] charArr = string.toCharArray();
		for (char c : charArr) {
			System.out.println(c);
		}
		
		//캐릭터 배열 -> 문자열 (이미 앞에서 한 것)
		System.out.println();
		
		//5. 특정 문자 기준으로 나누기 -> 배열로 반환 (중요)
		string = "가/나/다/라/마/바/사";
		String[] strArr = string.split("/"); // strArr -> {가, 나, 다, 라, 마, 바, 사}
		System.out.println(strArr[2]);
		System.out.println();
		for (String a : strArr) {
			System.out.println(a);
		}
		
		//특정 문자 위치 찾기
		string = "abcdabcdabcdabcd";
		intResult = string.indexOf("a");
		System.out.println("a의 위치: " + intResult); //a라는 문자가 몇번 인덱스에 있는가? 앞에서부터
		intResult = string.lastIndexOf("a");
		System.out.println("a의 위치: " + intResult); //a라는 문자가 몇번 인덱스에 있는가? 뒤에서부터
		
		System.out.println();
		
		
		//indexOf는 하나만 찾아주는 단점이 있음
		//그럼 string 안에 있는 모든 a를 찾기 위해서는? -> indexOf(Str, int) 사용 코드 리뷰
		intResult = 0; 
		while(intResult>-1) { 
			intResult = string.indexOf("a", intResult); 
			if (intResult>-1) {
				System.out.println("a의 위치: " + intResult); //0, 4, 8, 12, -1
				intResult++;

			}
		}
	}
}
