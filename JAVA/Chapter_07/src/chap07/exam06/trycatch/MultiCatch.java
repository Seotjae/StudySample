package chap07.exam06.trycatch;

public class MultiCatch {

	public static void main(String[] args) {
		//각 Exception 상황마다 다른 처리를 해줄 경우
		String[] variable = new String[2];
		
		try {

			variable[0] = "123456";
			variable[1] = "a12345";
			//variable[2] = "a2w3e4"; //ArrayIndexOutOfBoundsException 발생
			
			int val1 = Integer.parseInt(variable[0]);
			int val2 = Integer.parseInt(variable[1]); //NumberFormatException 발생
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스 범위를 확인해 주세요.");
			
		} catch (NumberFormatException e) {
			System.out.println("데이터가 숫자로만 구성되어 있는지 확인하세요.");
		} finally {
			System.out.println("===끝===");
		}
		
		
	}

}
