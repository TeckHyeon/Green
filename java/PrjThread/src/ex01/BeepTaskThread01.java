package ex01;

import java.awt.Toolkit;

//thread를 사용하기 위해 runnable 인터페이스가 필요하다
class ShowTask implements Runnable {
	// sysout("탕");
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println("탕");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class BeepTask implements Runnable {
	Toolkit toolkit = Toolkit.getDefaultToolkit();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// beep();

}

public class BeepTaskThread01 {

	public static void main(String[] args) throws InterruptedException {
		//첫번쨰 스레드 사용
		Runnable task = new ShowTask();
		Thread thread1 = new Thread(task);
		thread1.start();
		
		Runnable task2 = new BeepTask();
		Thread thread2 = new Thread(task2);
		thread2.start();
	}
}
