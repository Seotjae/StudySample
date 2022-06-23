package chap05.exam08.field;

public class Mage {

	public static void main(String[] args) {
		 
		//1. 다형성을 활용하지 않고 Fire, Ice, Light의 casting 실행
		Fire fire = new Fire();
		System.out.println(fire.casting());
		
		Ice ice = new Ice();
		System.out.println(ice.casting());
		
		Light light = new Light();
		System.out.println(light.casting());
		
		System.out.println();
		
		//2. 다형성을 활용
		Spell spell = new Fire(); //시작부터 Fire를 넣어도 상관없음
		//spell = new Fire();
		System.out.println(spell.casting());
		
		spell = new Ice();
		System.out.println(spell.casting());
		
		spell = new Light();
		System.out.println(spell.casting());
		
	}

}
