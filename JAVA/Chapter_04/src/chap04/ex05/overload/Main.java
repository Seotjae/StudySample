package chap04.ex05.overload;

public class Main {

	
	
	public static void main(String[] args) {
		
		/*생성자 오버로드가 없다면 아래와 같이 여러 형태로 객체화 할 때
	     *각각의 클래스를 만들어 줘야 한다.
		 */
		//생성자 오버로드를 사용해
		//최대한 다양한 생성자를 만들어 보세요~
		NoteBook notebook0 = new NoteBook("모델명", 100, "black");
		NoteBook notebook1 = new NoteBook("모델명", "black");
		NoteBook noteBook2 = new NoteBook("모델명", 100);
		NoteBook noteBook3 = new NoteBook("모델명");
		NoteBook noteBook4 = new NoteBook(100);
		NoteBook noteBook5 = new NoteBook();

		
		
	}

}
