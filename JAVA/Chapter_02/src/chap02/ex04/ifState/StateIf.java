package chap02.ex04.ifState;

public class StateIf {

	public static void main(String[] args) {
		//두부 사오기 (두부가 있으면 사온다)
		//두부 가게에 간다.
		System.out.println("두부 가게에 간다.");
		//만약 두부가 있다면 사온다.
		int tofuBox = 0;
		if (tofuBox>0) {
			System.out.println("두부를 산다.");
			System.out.println("두부를 받아서...");
		}
		
		//두부가 없다면 순두부를 산다.
		if (tofuBox<=0) {
			System.out.println("순두부를 산다.");
			
		}
		
		//집으로 돌아온다.
		System.out.println("집으로 돌아온다.");
	}

}
