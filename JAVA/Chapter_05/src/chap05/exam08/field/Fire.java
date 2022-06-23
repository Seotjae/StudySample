package chap05.exam08.field;

public class Fire extends Spell {
 
	@Override
	public String casting() {
		
		return "화염" + super.casting();
	}
	
	
	
}
