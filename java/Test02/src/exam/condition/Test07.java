package exam.condition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		int user = 0;
		// 스캐너 선언
		Scanner in = new Scanner(System.in);
		System.out.println("가위 바위 보");
		System.out.println("가위(1), 바위(2), 보(3) 입력 : ");
		user = in.nextInt();
		String userValue;
		switch (user) {
		case 1:
			userValue = "가위";
			break;
		case 2:
			userValue = "바위";
			break;
		case 3:
			userValue = "보";
			break;

		default:
			userValue = "에러";
			break;
		}
		System.out.println("유저는 " + userValue + "를 선택하였습니다.");
		int com = (int) (Math.random() * 3 + 1);
		String comValue;
		switch (com) {
		case 1:
			comValue = "가위";
			break;
		case 2:
			comValue = "바위";
			break;
		case 3:
			comValue = "보";
			break;

		default:
			comValue = "에러";
			break;
		}
		System.out.println("컴퓨터는 " + comValue + "를 선택하였습니다.");
		// 예외처리를 위한 while문
		while (true) {
			// 정수 이외의 값을 처리할 try catch문
			try {

				if (com - user == 2 || com - user == -1) {
					System.out.println("유저가 이김");
				} else {
					if (com - user == 0) {
						System.out.println("무승부");
					} else {
						if (com - user == 1 || com - user == -2) {
							System.out.println("컴퓨터가 이김");
						} else {
							if (user > 3) {
								System.out.println("올바른 숫자를 입력해주세요");
							}
						}
					}
				}
				break;
			} catch (InputMismatchException e2) {
				System.out.println("정수만 입력해주세요");
				// 처음부터 다시 실행
				in = new Scanner(System.in);
			}
		}

	}
}
