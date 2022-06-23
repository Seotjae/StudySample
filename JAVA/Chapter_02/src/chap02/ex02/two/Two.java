package chap02.ex02.two;

public class Two {

	public static void main(String[] args) {
		//나머지 연산(mod), %연산
		//홀수짝수, 배수 찾기에 주로 사용됨
		int mod = 5%2;
		System.out.println("5%2=" + mod);

		
		//JDK8.65
		String str1 = "JDK" + 8.65;
		System.out.println(str1);
		//JDK8.65의 특징
		String str2 = str1 + "의 특징";
		System.out.println(str2);
		
		//8.65 JDK
		String str3 = 8.65 + " JDK";
		System.out.println(str3);
				
		//1215A
		String str4 = 1215 + "A";
		str4 = "12" + 15 + "A";
		str4 = "" + 12 + 15 + "A";
		System.out.println(str4);
	}

}
