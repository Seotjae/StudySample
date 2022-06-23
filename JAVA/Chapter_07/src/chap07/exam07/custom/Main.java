package chap07.exam07.custom;

public class Main {

	public static void main(String[] args) {
		
		JoinMember join = new JoinMember();
		try {
			join.regId("root");
		} catch (Exception e) {
			//e.printStackTrace(); //예외에 대한 상세 정보를 알려줌
			System.out.println("입력하신 내용은 예약어 입니다.");
		}
		
	}

}
