package chap07.exam06.trycatch;

public class Main {

	public static void main(String[] args) {
		
		//try-catch는 문제가 발생한 곳에서 처리하겠다는 것
		String data1 = "12345";
		String data2 = "asdfg";
		
		try { //예외가 발생할 것 같은 영역

			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			
		} catch (NumberFormatException e) { //예외가 발생할 경우 처리할 내용, e = 예외 내용
			
			System.out.println("입력된 문자가 숫자로만 구성되어 있는지 확인 해 주세요!");
			System.out.println(e.toString()); //발생한 예외를 간략하게 알려줌
			
		}finally { //예외가 발생하거나 발생하지 않거나 무조건 실행할 내용

			System.out.println("입력받은 data1: " + data1);
			System.out.println("입력받은 data2: " + data2);
			
		}
		
		
		
		
		
		

	}

}
