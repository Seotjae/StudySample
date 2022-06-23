package chap05.exam08.field;

public class Light extends Spell {
 
	@Override
	public String casting() {
		
		return "번개" + super.casting();
	}
	
	
	
}
