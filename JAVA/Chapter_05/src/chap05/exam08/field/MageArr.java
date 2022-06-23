package chap05.exam08.field;

public class MageArr {

	public static void main(String[] args) {

		//Array와 for 문을 이용하여 연속되게 주문이 나가도록 해 보자
		
//		Fire fire = new Fire();
//		Ice ice = new Ice();
//		Light light = new Light();
		
		
		//배열은 하나의 데이터 타입만 받기 때문에 
		//다형성을 활용하지 않으면 각 개체들을 넣을 수 없다.
		Spell[] arr = {new Fire(), new Ice(), new Light()};
		System.out.println(arr [0]);
		
		System.out.println(arr[0].casting());
		System.out.println(arr[1].casting());
		System.out.println(arr[2].casting());
		
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].casting());
		}
		
		System.out.println();
		
		for (Spell  spell: arr) {
			System.out.println(spell.casting());
		}
		//다형성을 변수(field)에 활용 했으므로 - field 다형성 이라고 부른다.
	}

}
