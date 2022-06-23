package chap05.exam06.promotion;

public class Promotion {

	static Vertebrate 척추동물; //조류, 포유류, 닭, 오리, 고양이, 개
		
	public static void main(String[] args) {

		척추동물 = new Chicken();
		척추동물 = new Duck();
		척추동물 = new Cat();
		척추동물 = new Dog();
		
		
		//Cat은 Birds와 상속으로 연결되어 있지 않아서 들어갈수 없다.
		//Birds birds = new Dog();
		
		//Chicken은 Mammal과 상속으로 연결되어 있지 않아서 들어갈수 없다.
		//Mammal mal = new Chicken();
		
	}

}

/*       Vertebrate
       /           \
     Birds        Mammal 
    /     \      /     \
 Chicken Duck  Dog     Cat
*/
 
class Vertebrate {} //척추동물

class Birds extends Vertebrate {} //조류
class Mammal extends Vertebrate {} //포유류

class Chicken extends Birds{} //닭
class Duck extends Birds{} //오리

class Dog extends Mammal{} //개
class Cat extends Mammal{} //고양이


