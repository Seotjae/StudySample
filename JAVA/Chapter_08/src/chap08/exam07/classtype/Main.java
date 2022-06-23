package chap08.exam07.classtype;

public class Main {

	public static void main(String[] args) {
		Employee<Info> emp = new Employee<Info>(); //타입이 많다면 클래스, 하지만 몇개 안된다면 굳이
		
		//차이점 (핵심)
		//1. 안에 값을 넣을때 
		//emp에 들어갈 타입 객체를 만들고
		Info info = new Info();
		//그 안에 값을 넣고
		info.setEmp_no(20211020);
		info.setName("홍길동");
		info.setAge(35);
		info.setSalary(3000000);
		info.setAssets((long) 350000000);
		info.setCommission((float) 0.1);
		info.setMarried(false);
		info.setHobby("독서");
		//그 객체를 emp 안에 넣는다.
		emp.setInfo(info);
		
		//2. 값을 꺼낼 때
		info = emp.getInfo();
		//System.out.println(emp.getInfo());
		int age =  info.getAge(); //emp.getInfo().getAge();
		String name = info.getName();
		System.out.println(name + "의 나이는? " + age);
		
	}

}
