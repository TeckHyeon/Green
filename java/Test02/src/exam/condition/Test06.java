package exam.condition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		// 스캐너 선언
		Scanner in = new Scanner(System.in);
		// 예외처리를 위한 while문
		while (true) {
			// 정수 이외의 값을 처리할 try catch문
			try {
				// 국어 점수
				System.out.println("국어 점수를 입력하세요");
				int a = in.nextInt();
				// 영어 점수
				System.out.println("영어 점수를 입력하세요");
				int b = in.nextInt();
				// 수학 점수
				System.out.println("수학 점수를 입력하세요");
				int c = in.nextInt();
				// 합계
				int d = a + b + c;
				// 평균
				int e = d / 3;
				System.out.println("총점은" + " " + d + "점 입니다.");
				System.out.println("평균은" + " " + e + "점 입니다.");
				// 성적 조건 if문
				switch (e / 10) {
				case 10: case 9:
					System.out.println("귀하의 성적은 A 입니다.");
					break;
				case 8:
					System.out.println("귀하의 성적은 B 입니다.");
					break;
				case 7:
					System.out.println("귀하의 성적은 C 입니다.");
					break;
				case 6:
					System.out.println("귀하의 성적은 D 입니다.");
					break;
				default:
					System.out.println("귀하의 성적은 F 입니다.");
					break;
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
