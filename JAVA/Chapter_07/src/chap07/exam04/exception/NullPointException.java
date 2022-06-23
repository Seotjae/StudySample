package chap07.exam04.exception;

public class NullPointException {

	public static void main(String[] args) {
		//null 값인데 무언가를 시킬 경우
		//runtime exception은 실행하기 전까지 알수가 없다.
		String data = null;
		boolean eq = data.equals("");
		System.out.println("같은가? :" + eq);
		
		
	}

}
