package iterate;

public class TestFor04 {
	public static void star1() {
		line(1);
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
	}

	public static void star2() {
		line(2);
		for (int i = 1; i <= 6; i++) {
			System.out.println("*** " + i + " ***");
		}
	}

	public static void star3() {
		line(3);
		for (int i = 1; i <= 5; i++) {
			System.out.print("*****");
			System.out.println();
		}
	}

	public static void star4() {
		line(4);
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public static void star5() {
		line(5);
		for (int i = 1; i <= 5; i++) {
			for (int k = 2; k <= i; k++) {
				System.out.print(" ");
			}
			for (int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}

	}

	public static void star6() {
		line(6);
		for (int i = 1; i <= 5; i++) {
			for (int k = 4; k >= i; k--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}

	}

	public static void star7() {
		line(7);
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				for (int k = 8; k >= i; k--) {
					if (k % 2 == 1) {
						System.out.print(" ");
					}
				}
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.print("\n");
			}
		}
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				for (int k = 0; k <= i; k++) {
					if (k % 2 == 1) {
						System.out.print(" ");
					}
				}
				for (int j = 8; j >= i; j--) {
					System.out.print("*");
				}
				System.out.print("\n");
			}
		}
	}

	public static void star8() {
		line(8);
		for (int i = 1; i <= 8; i++) {
			for (int k = 8; k >= i; k--) {
				System.out.print("*");

			}

			for (int l =2; l <= 2*i; l++) {
				System.out.print(" ");

			}
			for (int k = 8; k >= i; k--) {
				System.out.print("*");

			}
			System.out.print("\n");
		}
		for (int i = 2; i <= 8; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
				
			}
			
			for (int l = 16; l >= 2*i; l--) {
				System.out.print(" ");
				
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
				
			}
			System.out.print("\n");
		}

	}

	private static void line(int n) {
		System.out.println("\n" + n + "-------------------------------------------");

	}

	public static void main(String[] args) {
		//
		star1();
		star2();
		star3();
		star4();
		star5();
		star6();
		star7();
		star8();

	}

}
