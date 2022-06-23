package chap06.exam01.abs;

public abstract class Mammal { //추상 class는 abstract가 붙는다.
	
	public String name;
	
	public Mammal(String name) {
		this.name = name;
	}

	public void birth() {
		System.out.println(name + "가 아이를 낳는다.");
	}
	
	public void eat() {
		System.out.println(name + "가 젖을 먹인다.");
		
	}



}
