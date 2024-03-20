package iterate;

public class TestFor03 {
	public static void main(String[] args) {
		// 메소드(method) : class 안에 있는 함수(function) - 프로그램 조각

		for (int i = 1; i <= 10; i++) {
			System.out.println("홍길동");
			System.out.println(i + "번 반복했습니다.");
		}
		line();
		for (int i = 1; i <= 5; i++) {
			System.out.print(i);
			System.out.print(".");
			System.out.print("카리나");
			System.out.print("\n");
		}
		line();
		for (int i = 2; i <= 10; i = i + 2) {
			System.out.print(i);
			System.out.print(".");
			System.out.print("카리나");
			System.out.print("\n");
		}
		line();
		for (int i = 5; 1 <= i; i--) {
			System.out.print(i);
			System.out.print(".");
			System.out.print("카리나");
			System.out.print("\n");
		}
	}

	private static void line() {
		System.out.println("-------------------------------------------");
		return;

	}
}
