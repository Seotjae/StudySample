package chap08.exam01.string;

public class StringMethod {

	public static void main(String[] args) {
		//문자열 만들기: str1 이라는 변수에 "abcdefg" 넣기
		String str1 = "abcdefg";
		
		//String이 클래스이기 때문에 가능한 방법. 
		//이게 원래는 정석 str1 이나 str2나 똑같다.
		String str2 = new String("abcdefg"); 
		
		//String이 char 배열로 간주되기 때문에 가능한 방법 -> 기계와 통신할 경우 사용되기도 함
		char[] alphabet = {'a','b','c','d','e','f','g'};
		String str3 = new String(alphabet);
		System.out.println(str2);
		
	}

}
