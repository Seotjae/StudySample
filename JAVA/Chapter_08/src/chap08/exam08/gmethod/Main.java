package chap08.exam08.gmethod;

public class Main {

	public static void main(String[] args) {
		GMethod gm = new GMethod();
		gm.method1("최성재");
		gm.method1(100);
		gm.method1(true);
		
		System.out.println(gm.method2(100));
		System.out.println(gm.method2("홍길동"));
		System.out.println(gm.method2('a'));
		
		Box<String> box = gm.method3("구디아카데미");
		System.out.println(box.getT());
	}

}
