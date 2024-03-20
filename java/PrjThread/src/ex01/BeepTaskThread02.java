package ex01;

import java.awt.Toolkit;

public class BeepTaskThread02 {

	public static void main(String[] args) {
		// 두번째 방법 : 익명 클래스(Anonymous Class)
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("탕");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		thread1.start();

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
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

			}
		});

		thread2.start();

	}

}
