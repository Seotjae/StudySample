package chap11.exam01.sysio;

import java.io.IOException;
import java.io.OutputStream;

public class SysOutput {

	public static void main(String[] args) throws IOException {
		OutputStream os = System.out;
//		//System.out.println();
//		//97~122번 코드를 출력
//		for (byte b = 97;  b <= 122; b++) {
//			os.write(b); //바이트나 인트가 들어가야 함
//		}
//		
//		os.flush(); //output 할 때 필수적으로 해줘야 하는 기능
//		os.close(); //자원반납, 나중에 꼭 해줘야 하는 기능
		
		//os.write()를 활용해서 문자열 찍어보기
		String hangul = "가나다라마바사아자차카타파하";
		char[] charArr = hangul.toCharArray();
		for (char c : charArr) {
			byte i = (byte) c;
			os.write(i);
		}
		os.write(13); //enter -> new line

		os.write(hangul.getBytes());
		
		os.flush();
		os.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
