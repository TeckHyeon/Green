package exam.condition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		// 스캐너 선언
		Scanner in = new Scanner(System.in);
		while (true) {
			try {
				int user = 0;
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

				int result = com - user;
				if (user > 3 || user <= 0) {
					System.out.println("1~3의 숫자만 입력할 수 있습니다.");
					
				} else {

					switch (result) {
					case 2:
					case -1:
						System.out.println("유저가 이김");
						break;
					case 0:
						System.out.println("무승부");
						break;
					case 1:
					case -2:
						System.out.println("컴퓨터가 이김");
						break;
					default:
						System.out.println("1~3의 숫자만 입력해주세요");
						break;
					}
				}
//		switch (user) {
//		case 1:
//			switch (com) {
//			case 1:
//				System.out.println("무승부");
//				break;
//			case 2:
//				System.out.println("컴퓨터가 이김");
//				break;
//			case 3:
//				System.out.println("유저가 이김");
//				break;
//			default:
//				System.out.println("에러");
//				break;
//			}
//			break;
//		case 2:
//			switch (com) {
//			case 1:
//				System.out.println("유저가 이김");
//				break;
//			case 2:
//				System.out.println("무승부");
//				break;
//			case 3:
//				System.out.println("컴퓨터가 이김");
//				break;
//			default:
//				System.out.println("에러");
//				break;
//			}
//			break;
//		case 3:
//			switch (com) {
//			case 1:
//				System.out.println("컴퓨터가 이김");
//				break;
//			case 2:
//				System.out.println("유저가 이김");
//				break;
//			case 3:
//				System.out.println("무승부");
//				break;
//			default:
//				System.out.println("에러");
//				break;
//			}
//			break;
//		default:
//			System.out.println("에러");
//			break;
//		}

				break;
			} catch (InputMismatchException e2) {
				System.out.println("1~3의 숫자만 입력해주세요");
				// 처음부터 다시 실행
				in = new Scanner(System.in);
			}
		}

	}
}
