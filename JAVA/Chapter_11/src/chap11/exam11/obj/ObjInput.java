package chap11.exam11.obj;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class ObjInput {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//파일 불러오기 순서
		//주 스트림 준비, 파일 위치 지정
		FileInputStream fis = new FileInputStream("C:/img/temp/obj.dat");
		
		//보조 스트림 준비
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//읽어오기(순서 중요)
		//Hashmap
		HashMap<String, String> map = (HashMap<String, String>) ois.readObject();
		//array
		int[] scores = (int[]) ois.readObject();
		//String
		String msg = ois.readUTF();
		//Sample class
		Sample sample = (Sample) ois.readObject();
		
		System.out.println("msg: " + msg);
		
		for (int score : scores) {
			System.out.println("score: " + score);
		}
		
		for (String key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
		
		System.out.println(sample.num + "/" + sample.job + "/" + sample.team);
		System.out.println(sample.method());
		
		
		//자원반납
		ois.close();
		
	}

}
