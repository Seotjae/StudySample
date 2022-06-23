package chap06.exam07.couple;

public class Client {

	public static void main(String[] args) {
		
		//VingsuConcrete 객체화 
		//RedBeanVingsu ChocoVingsu CookieVingsu를 만들기
		VingsuConcrete make = new VingsuConcrete();
//		Vingsu vingsu = null;
//		vingsu = new RedBeanVingsu(); 
//		그릇에 한번 담아서 넣어도 된다
		
		make.makeVingsu(new RedBeanVingsu());
		System.out.println();
		make.makeVingsu(new ChocoVingsu());
		System.out.println();
		make.makeVingsu(new CookieVingsu());
		System.out.println();
		
		
		
//		System.out.println("배열"); 
//		배열에 담음
//		Vingsu[] type = {new RedBeanVingsu(), new ChocoVingsu(), new CookieVingsu()};
//		make.makeVingsu(type[0]);
//		System.out.println();
//		make.makeVingsu(type[1]);
//		System.out.println();
//		make.makeVingsu(type[2]);
	}

}
