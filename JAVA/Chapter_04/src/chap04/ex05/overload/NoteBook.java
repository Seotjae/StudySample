package chap04.ex05.overload;

public class NoteBook {

	String model;  //모델명
	int price; //가격
	String color; //색상
	
	
	public NoteBook(String model, int price, String color) { //생성자
		this.model = model;
		this.price = price;
		this.color = color;
	}
	/*
	public NoteBook(int price, String model, String color) {
		this.model = model;
		this.price = price;
		this.color = color;
	}

	public NoteBook(String model, String color, int price) {
		this.model = model;
		this.price = price;
		this.color = color;
	}
	*/
	public NoteBook(String model, int price) {
		this.model = model;
		this.price = price;
	}

	public NoteBook(String model, String color) {
		this.model = model;
		this.color = color;
	}
	/*
	public NoteBook(int price, String color) {
		this.price = price;
		this.color = color;
	}
	*/
	public NoteBook(String model) {
		this.model = model;
	}
	
	/*
	public NoteBook(String color) {
		
	}
	*/
	
	public NoteBook(int price) {
		this.price = price;
	}

	public NoteBook() {
		
	}







}
