package chap08.exam09.inherit;

public class Main {

	public static void main(String[] args) {
		
		//뒤 제너릭 안의 타입은 생략 가능(다이아몬드 연산자)
		//효율성은 별로, 웬만하면 쓰지 않는다.
		DetailInfo<String, Integer, String> info = new DetailInfo<>();
		
		info.setName("홍길동");
		info.setAge(42);
		info.setHobby("영화");
		
		System.out.println(info.getName());
		System.out.println(info.getAge());
		System.out.println(info.getHobby());
		
		
	}

}
