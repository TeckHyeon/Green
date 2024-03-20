package ex01;

public class BeenTask01 {

	public static void main(String[] args) throws InterruptedException {
		
		
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();		
		for (int i = 0; i < 5; i++) {
			System.out.println("탕");
			Thread.sleep(500); // 1000 : 1초 대기한 후 다시 실행
		}


		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			Thread.sleep(500);
		}

	}

}
