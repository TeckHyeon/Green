package trycatch01;

public class TryCatchTest {

	public static void main(String[] args) {

		int v1 = 7;
		int v2 = 3;
		int v;

		// v = v1 / v2; // 실행시 오류 -> exception : ArithmeticException

		// 예외처리
		System.out.println(1);

		try {
			v = v1 / v2;
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("관리자에게 문의...계산문제발생:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("문제발생:" + e.getMessage());
		} finally { // exception 발생 상관없이 무조건 실행 : file close
			System.out.println("Hi");
		}

	}

}
