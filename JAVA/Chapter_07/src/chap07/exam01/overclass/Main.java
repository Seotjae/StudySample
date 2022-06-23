package chap07.exam01.overclass; 
//그냥 클래스안에 클래스가 존재한다만 알면 됨

//Exclass. 을 붙일경우 불러오기 필요없음
import chap07.exam01.overclass.Exclass.InsClass;


public class Main {

	public static void main(String[] args) {
		
		//1. 인스턴스 멤버 클래스 호출
		Exclass ex = new Exclass();//외부 클래스를 먼저 객체화
		//객체화 된 하위 클래스를 객체화 하는 과정임
		Exclass.InsClass ins = ex.new InsClass();
		ins.field = 3;
		ins.method();
		
		//2. 정적 멤버 클래스 호출
		//정적 멤버 클래스 내 정적 필드와 메서드 호출
		Exclass.StaticClass.stField = 4;
		Exclass.StaticClass.stMethod();
		//정적 멤버 클래스 내 인스턴스 필드와 메서드 호출
		Exclass.StaticClass stClass = new Exclass.StaticClass();
		stClass.field = 10;
		stClass.method();
		
		//3. 로컬 인스턴스 클래스 호출 - 메서드 호출하면 된다.
		ex.localMethod();
		
	}

}
