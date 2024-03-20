package TestFor01;

public class TestStars {

	public static void main(String[] args) {
		//
		star1();
		star1_3();
		star2();
		star3();
	}

	private static void star1_3() {
		for (int i = 0; i < 5; i++) {
			System.out.print("*****");
			System.out.print("\n");
		}
		System.out.println();
	}

	private static void star1() {

		for (int i = 1; i < 10; i++) {
			System.out.print("  ");
			System.out.println("******");
		}

	}

	private static void star2() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private static void star3() {
		for (int i = 0; i < 5; i++) {
			for (int j = 3; j >= i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}