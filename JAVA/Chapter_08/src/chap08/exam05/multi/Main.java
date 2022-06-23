package chap08.exam05.multi;

public class Main {

	public static void main(String[] args) {
		
		MultiBox<String, Integer> box = new MultiBox<String, Integer>();
		//값 넣기
		box.setKey("비밀번호");
		box.setValue(1234);
		
		//값 꺼내기
		String key = box.getKey();
		int value = box.getValue();
		System.out.println(key + ": " + value);
		//System.out.println(box.getKey() + box.getValue());

		
		
		
	}

}
