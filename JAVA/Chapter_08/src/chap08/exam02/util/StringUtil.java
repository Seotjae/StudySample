package chap08.exam02.util;

public class StringUtil {

	//String에서 사용하는 유용한 메서드들 써보기
	public static void main(String[] args) {
		String string = "abcdefg";
		
		String stringResult;
		int intResult;
		boolean boolResult;
		
		//문자열 비교
		boolResult = string.equals("abc");
		System.out.println("두 문자가 같습니다? " + boolResult);
		
		//문자열 포함
		boolResult = string.contains("abc");
		System.out.println("abc를 포함하는가? " + boolResult);
		
		//문자열 교체
		stringResult = string.replace("abc", "ABC"); //앞에 있는 내용을 뒤에 있는 내용으로 교체
		System.out.println(string + " => " + stringResult);
		
		//앞뒤 공백 제거
		System.out.println();
		string = " 가나다라마바사 ";
		stringResult = string.trim();
		System.out.println(string);
		System.out.println(stringResult);
		
		//문자열 찾기
		//1. 특정 문자열로 시작되는가?
		string = "[img]uploadFile.png";
		boolResult = string.startsWith("[img]");
		System.out.println("[img]로 시작하는 파일인가? " + boolResult);
		
		//2. 특정 문자열로 끝나는가?
		boolResult = string.endsWith(".png");
		System.out.println(".png로 끝나는가? " + boolResult);
		
		//3. 일치하지 않는 갯수는 몇개인가?
		intResult = string.compareTo("[img]uploadFile.pn");
		System.out.println("일치하지 않는 문자 갯수: " + intResult);
		
		
		
	}

}
