package chap07.exam04.exception;

public class NumberFormatException {

	public static void main(String[] args) {
		//문자를 숫자로 바꿀때 형식이 맞지 않아 발생
		String data;
		int val;
		
		//"1234" -> 1234 가능
		data = "1234";
		val = Integer.parseInt(data);
		System.out.println(val);
		
		//문자열이긴 하나 형식은 숫자가 아님
		data = "data = 1234";
		val = Integer.parseInt(data);
		System.out.println(val);
		
		
		
		
	}

}
