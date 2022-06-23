package chap06.exam07.couple;

public class VingsuConcrete {

	//Vingsu 인터페이스를 구현받은 객체들은 다 매개변수로 사용이 가능
	public void makeVingsu(Vingsu vingsu) {
		vingsu.iceFlake();
		vingsu.milk();
		vingsu.redBean();
		vingsu.jelly();
		vingsu.etc();
		
		
		
		
	}
	
}
