package chap01.ex04.method;

public class Selfstuudy {

	public static void main(String[] args) {
		int 동전 = 500;
		String 봉투 = 자판기(동전);
		System.out.println(봉투);
		
		String 쓰레기 = "종이";
		쓰레기통(쓰레기);
		String 손 = 손세정제();
		System.out.println(손);
		자전거();

	}
		//매개변수 : O, 반환값 : O
		public static String 자판기(int 동전) {
			return "해당하는 물건";
		}
		
		//매개변수 : O, 반환값 : X
		public static void 쓰레기통(String 쓰레기) {
		System.out.println(쓰레기 + "를 넣는다.");
		}
			
		//매개변수 : X, 반환값 : O
		public static String 손세정제() {
			return "세정제";
		}
		
		//매개변수 : X, 반환값 : X
		public static void 자전거() {
			System.out.println("페달을 돌린다");
		}

}
