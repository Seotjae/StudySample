package chap08.exam06.multi;

public class Employee<S, I, L, B, F> {
	
	private S name;
	private I num;
	private I age;
	private I pay;
	private L money;
	private F bonus;
	private B marry;
	private S hobby;
	
	
	public S getName() {
		return name;
	}
	public void setName(S name) {
		this.name = name;
	}
	public I getNum() {
		return num;
	}
	public void setNum(I num) {
		this.num = num;
	}
	public I getAge() {
		return age;
	}
	public void setAge(I age) {
		this.age = age;
	}
	public I getPay() {
		return pay;
	}
	public void setPay(I pay) {
		this.pay = pay;
	}
	public L getMoney() {
		return money;
	}
	public void setMoney(L money) {
		this.money = money;
	}
	public F getBonus() {
		return bonus;
	}
	public void setBonus(F bonus) {
		this.bonus = bonus;
	}
	public B getMarry() {
		return marry;
	}
	public void setMarry(B marry) {
		this.marry = marry;
	}
	public S getHobby() {
		return hobby;
	}
	public void setHobby(S hobby) {
		this.hobby = hobby;
	}
	
	
	
}
