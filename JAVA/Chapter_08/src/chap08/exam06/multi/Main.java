package chap08.exam06.multi;

public class Main {

	public static void main(String[] args) {
		
		//객체화 시 타입지정 할 떄 순서가 변경되면 안된다.
		//그래서 필드들을 보면서 객체화를 해야한다.
		Employee<String, Integer, Long, Boolean, Float> emp 
		= new Employee<String, Integer, Long, Boolean, Float>();
		//그리고 객체화 한 내용도 가독성이 좋지 않다.
		
		//차이점
		//1. 안에 값을 넣을 때 -> emp로 직접 값을 넣음, 바로 값을 넣으면 된다.
		emp.setNum(20211020);
		emp.setName("홍길동");
		emp.setAge(35);
		emp.setPay(3000000);
		emp.setMoney((long) 350000000);
		emp.setBonus((float) 0.1);
		emp.setMarry(false);
		emp.setHobby("독서");
		
		//2. 값을 꺼낼 때
		int num = emp.getNum();
		String name = emp.getName();
		int age = emp.getAge();
		int pay = emp.getPay();
		long money = emp.getMoney();
		float bonus = emp.getBonus();
		boolean marry = emp.getMarry();
		String hobby = emp.getHobby();
		System.out.println(name + "의 나이는? " + age);
		
		
		
		
		
		
	}

}
