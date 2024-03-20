package iterate;

public class TestFor02 {
	public static void main(String[] args) {
//		1에서 10까지 숫자를 1씩 증가하면서 {}을 반복 실행
		for (int i = 1; i <= 10; i++) {
			System.out.println("홍길동");
			System.out.println(i + "번 반복했습니다.");
		}
		System.out.println("-------------------------------------------");
		for (int i = 1; i <= 5; i++) {
			System.out.print(i);
			System.out.print(".");
			System.out.print("카리나");
			System.out.print("\n");
		}
		System.out.println("-------------------------------------------");
		for (int i = 2; i <= 10; i = i + 2) {
			System.out.print(i);
			System.out.print(".");
			System.out.print("카리나");
			System.out.print("\n");
		}
		System.out.println("-------------------------------------------");
		for (int i = 5; 1<= i; i--) {
			System.out.print(i);
			System.out.print(".");
			System.out.print("카리나");
			System.out.print("\n");
		}
	}
}
