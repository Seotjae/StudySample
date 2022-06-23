package chap05.exam01.inherit;

//클래스를 만들면서 상속받은 클래스
//상속은 하나만 가능하다. (인간이 포유류면서 조류일수 없듯이)
public class Persons extends Mammal {
	
	public void useTool() {
		System.out.println("도구를 사용한다.");
	}

	public void social() {
		System.out.println("사회 생활을 한다.");
	}
	
	public void talk() {
		System.out.println("이야기를 한다.");
	}
	
	
}
