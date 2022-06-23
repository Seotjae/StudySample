package chap11.exam11.obj;

import java.io.BufferedOutputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class ObjOutput {

	public static void main(String[] args) throws IOException {
		//내보내기 순서
		//주 스트림 준비, 경로 지정
		FileOutputStream fos = new FileOutputStream("C:/img/temp/obj.dat");
		
		//보조 스트림 준비
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//쓰기 
		//map, list
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "kim");
		map.put("phone", "01012341234");
		oos.writeObject(map);
		
		//array
		oos.writeObject(new int[] {90, 95, 90, 100});
		
		//기본 형태
		oos.writeUTF("기본 데이터 타입은 DataOutPutStream에서 쓰던 것처럼 사용 가능");
		
		//클래스 객체 형태 (인터페이스 구현 필수)
		oos.writeObject(new Sample());
		
		//스트림 비우기, 자원반납
		oos.flush();
		oos.close();
		
	}

}
