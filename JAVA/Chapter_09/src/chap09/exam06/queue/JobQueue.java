package chap09.exam06.queue;

import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {

	public static void main(String[] args) {
		//queue 생성 (Queue는 interface)
		Queue<Job> queue = new LinkedList<Job>();
		
		//해야할 일 넣기 (offer)
		queue.offer(new Job("send SMS", "Alice"));
		queue.offer(new Job("send Mail", "Bryan"));
		queue.offer(new Job("send SMS", "Cris"));
		queue.offer(new Job("send push message", "Denis"));
		queue.offer(new Job("send SMS", "Erick"));
		
		//하나씩 뽑아내기 (poll)
		//모든 작업 내용을 뽑아서 실행하기
		while (!queue.isEmpty()) {
//			System.out.println(queue.peek().getTo() + "에게 " + queue.poll().getCommand() + "하기");
			Job job = queue.poll();
			System.out.println(job.getTo() + job.getCommand());
		
		}
		

	}

}
