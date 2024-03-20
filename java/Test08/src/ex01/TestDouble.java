package ex01;


public class TestDouble {

	public static void main(String[] args) {
		float f = 0.0f;
		for (int i = 1; i <= 10000; i++) {
			f = f + 0.1f;
		}
		System.out.println(f); //999.9029
		double d = 0.0;
		for (int i = 1; i <= 10000; i++) {
			d = d + 0.1;
		}
		System.out.println(d); // 1000.0000000001588
	}

}
