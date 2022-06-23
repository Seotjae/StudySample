package chap05.exam01.inherit;

public class Main {

	public static void main(String[] args) {
		
		Persons persons = new Persons();
		//Persons 기능들
		persons.useTool(); 
		persons.social();
		persons.talk();
		
		//Mammal로 부터 상속받은 기능들
		persons.birth();
		persons.eat();
	
		//원래는 Mammal이라는 클래스의 기능을 사용하기 위해서는..
		//Mammal을 객체화 하여 가져와야 한다.
		Mammal mal = new Mammal();
		mal.birth();
		mal.eat();
		
		Person person = new Person();
		person.birth();
		
		//상속을 사용하면 하나의 클래스만 기억하면
		//상속받은 내용들은 그냥 사용하면 된다.
	
	}

}
