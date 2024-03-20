package collection03;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		//LinkedList<String> llist = new LinkedList<>();
		Queue<String>      queue = new LinkedList<>(); // LinkedList queue 로 사용한다
			
		queue.add("일");
		queue.add("월");
		queue.add("수");
		queue.add("목");
		queue.add("금");
		
		System.out.println( queue.poll() + queue.size() );
		System.out.println( queue.poll() + queue.size() );
		System.out.println( queue.poll() + queue.size() );
		System.out.println( queue.poll() + queue.size() );
		System.out.println( queue.poll() + queue.size() );
		//주소는 역순으로 호출은 순서대로
	}

}








