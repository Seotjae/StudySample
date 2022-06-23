package chap11.exam05.fileoutput;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputRiview {

	public static void main(String[] args) throws IOException {
		String oriPath = "C:/img/dog.jpg";
		String targetPath = "C:/img/temp/image.jpg";
		
		FileInputStream fis = new FileInputStream(oriPath);
		FileOutputStream fos = new FileOutputStream(targetPath, false);
		
		int data;
		int i = 0; 
		while ((data = fis.read()) != -1) {
			i++;
			System.out.println("파일 복사중 " + i);
			fos.write(data);
		}
		
//		int i =0;
//		byte[] arr = new byte[1024]; 
//		while (fis.read(arr) != -1) { 
//			fos.write(arr);
//			i++;
//			System.out.println("파일 복사중 " + i); 
//		}

		fos.flush();
		fis.close();
		fos.close();
		
		
	}

}
