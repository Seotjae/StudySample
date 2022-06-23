package chap04.ex04.conStr;

public class Main {

	public static void main(String[] args) {
	
		//초기화: 최초로 생성되었을 때 무언가 값을 주는 행위
		//로봇이 생성될 때 이름과 할 일을 줄 것이다
		Robot robot = new Robot("AD345", "집안청소"); //new 이후에 호출하는 것이 생성자
		Robot robot1 = new Robot();
		Robot robot2 = new Robot("kim");
		
		
	}//

}//
