package chap02.ex04.ifState;

public class StateElse {

	public static void main(String[] args) {
		//만약 두부가 있다면 두부를 사오고
		//두부가 없으면 순두부를 사온다.
		System.out.println("두부 가게에 간다.");
		int tofuBox = 0;
		if (tofuBox>0) {
			System.out.println("두부를 산다.");
		} else {
			System.out.println("순두부를 산다.");
		}
		System.out.println("집으로 돌아온다.");

	}

}
