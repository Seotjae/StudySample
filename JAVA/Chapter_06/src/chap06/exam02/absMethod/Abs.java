package chap06.exam02.absMethod;

public abstract class Abs {
	
	//추상 메서드 : 몸체가 없다, 추상 클래스에서만 만들 수 있다.(일단은 그렇게만 알고 있자.)
	//+must1():void(abstract)
	public abstract void must1();
	
	//+must2():void(abstract)
	public abstract void must2();
	
		
	public void parent() {
		System.out.println("그냥 쓰거나 오버라이드 할 수 있는 부모 메서드");
	}
	
	
}
