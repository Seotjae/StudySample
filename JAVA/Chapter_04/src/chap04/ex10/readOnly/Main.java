package chap04.ex10.readOnly;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person("Korea", "최성재"); //생성자 호출 시 초기화
		//Korea와 최성재라는 값은 변경 불가
		
		/* 변경하고 싶다면 final을 지우라는 안내가 나타난다.
		 * person.nation = "한국";
		 * person.name = "홍길동";
		 */
		System.out.println(person.name);
		System.out.println(person.nation);
		
		
		

	}

}
