package ex01;

import java.awt.Toolkit;

public class BeepTaskThread03 {

	public static void main(String[] args) {
		// 세번째 방법 : 람다식 사용
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("탕");
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		thread1.start();
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				toolkit.beep();
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		thread2.start();
	}

}
