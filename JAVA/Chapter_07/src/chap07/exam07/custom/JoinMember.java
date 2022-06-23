package chap07.exam07.custom;

public class JoinMember {
	
	String[] reserved = {"admin", "super", "root", "tester"};
	
	//어떤 아이디를 입력하면 예약어인지 확인하여 예약어일 경우 예외 발생
	public void regId(String userID) throws Exception {
	//userId 값이 reserved 안에 있는 값인지 확인하여 있으면 "예약어 입니다."를 출력
		for (String string : reserved) {
			if (userID.equals(string)) {
				System.out.println("예약어 입니다.");
				//break;
				
				//throw new XXXException("원하는 메세지")
				//throw new RuntimeException("실행 예외 강제 발생");
				//throw new Exception("일반 예외 강제 발생"); 
				//throw new로 강제로 예외 발생 가능 (중요)
				//일반예외는 이클립스가 빨간줄로 잡아준다 (중요)
				
			}
		}	
	}
}
