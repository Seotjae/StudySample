package chap11.exam10.data;

import java.io.DataInputStream;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInput {

	public static void main(String[] args) throws IOException {
		//파일 읽어오기 순서
		//주 스트림 준비 + 파일 위치 지정
		FileInputStream fis = new FileInputStream("C:/img/temp/object.dat");
		
		//보조 스트림 준비
		DataInputStream dis = new DataInputStream(fis);
		
		//읽어오기 -> 주의사항: 쓴 순서대로 읽어와야 함
		String name = dis.readUTF();
		int salary = dis.readInt();
		boolean promotion = dis.readBoolean();
		System.out.println(name + "/" + salary + "/" + promotion);
		
		//자원반납
		dis.close();
		
	}

}
