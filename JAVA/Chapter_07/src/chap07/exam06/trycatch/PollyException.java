package chap07.exam06.trycatch;

public class PollyException {

	public static void main(String[] args) {
		String[] variable = new String[2];
		
		try {

			variable[0] = "123456";
			variable[1] = "a12345";
			variable[2] = "a2w3e4"; //ArrayIndexOutOfBoundsException 발생
			
			int val1 = Integer.parseInt(variable[0]);
			int val2 = Integer.parseInt(variable[1]); //NumberFormatException 발생
			
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
			System.out.println(e.toString());
		} finally {
			System.out.println("===끝===");
		}
		

		
	}
	
	

}
