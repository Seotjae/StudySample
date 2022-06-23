package chap04.ex08.sMember;

public class Inner {

	public static void main(String[] args) {
		//1. st_msg("hello static member") 실행 해 보기
		Inner.st_msg("hello static member"); //같은 클래스에 같은 영역이므로 그냥 부르면 된다.
		
		//2. h_msg("hello java") 실행 해 보기
		//같은 클래스지만 다른 영역에 존재하므로 객체화 하여 불러온다.
		Inner in = new Inner(); //같은 클래스지만 h_msg은 heap 영역에 있으므로 Inner 클래스 객체화
		in.h_msg("hello java"); //객체화 후 메서드 호출
	}
	
	static void st_msg(String s) { //static 영역
		System.out.println("static member method: " + s);
		
		
	}

	void h_msg(String s) { //heap 영역
		System.out.println("member method: " + s);
		
		
	}
	
}
