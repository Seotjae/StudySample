package chap09.exam05.stack;

import java.util.Stack;

public class TowelBox {

	public static void main(String[] args) {
		
		Stack<Towel> box = new Stack<Towel>();
		//수건 넣기 push()
		box.push(new Towel("red"));
		box.push(new Towel("orange"));
		box.push(new Towel("yellow"));
		box.push(new Towel("green"));
		box.push(new Towel("blue"));
		box.push(new Towel("navy"));
		box.push(new Towel("purple"));
		//어떤 색 순서로 쌓여있나
		/* purple
		 * navy
		 * blue
		 * green
		 * yellow
		 * orange
		 * red
		 */

		//수건을 하나씩 빼기 pop() & peek()
		//반환된 객체를 받아서 바로 객체를 사용 -> 메서드 체이닝
		System.out.println("pop() : " + box.pop().getColor()); //꺼내서 쓰고 버림
		System.out.println("peek() : " + box.peek().getColor()); //꺼내서 쓰고 다시 넣음
		System.out.println("peek() : " + box.peek().getColor());
		
		//box 안에 있는 towel을 모두 꺼내보자 -> size or isEmpty
		while (!box.isEmpty()) {
			System.out.println(box.pop().getColor() + "색 수건을 꺼낸다."); //pop을 peek으로 잘못 사용하면 무한루프 
			System.out.println(box.size() + "장 남음");
			System.out.println("================================");
		}
		
		
		
		
	}

}
