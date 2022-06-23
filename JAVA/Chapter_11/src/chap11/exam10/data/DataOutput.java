package chap11.exam10.data;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutput {

	public static void main(String[] args) throws IOException {
		//파일 내보내기 순서
		//주 스트림 준비 + 파일 위치 지정
		FileOutputStream fos = new FileOutputStream("C:/img/temp/object.dat", true);
		
		//보조 스트림 준비
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		//쓰기
		dos.writeUTF("최성재");
		dos.writeInt(6000000);
		dos.writeBoolean(true);
		
		//스트림 비우기, 자원반납
		dos.flush();
		dos.close();
		
	}

}
