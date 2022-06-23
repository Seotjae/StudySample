package chap07.exam03.overInter;

public class Main {

	public static void main(String[] args) {
		
		//점선: 호출하는 메서드가 끝남과 동시에 객체가 사라질 경우
		Element elem = new Element();
		elem.regist(new OnclickListener());
		elem.trigger();
		
		elem.regist(new OnkeyListener());
		elem.trigger();
	
	}

}
