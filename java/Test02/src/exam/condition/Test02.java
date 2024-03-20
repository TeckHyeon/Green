package exam.condition;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
//try (	//		1 입력 => "A" 출력
//		//		2 입력 => "B" 출력
//		//		3 입력 => "C" 출력
//		//		그 외 입력 => "잘못 입력" 출력
//		Scanner in = new Scanner(System.in)) {
//			System.out.println("번호를 입력하세요");
//			int a = in.nextInt();
//			if(a == 1) {
//				System.out.println("A");
//			} else if(a == 2) {
//				System.out.println("B");
//			} else if (a == 3) {
//				System.out.println("C");
//			} else {
//				System.out.println("잘못 입력");
//			}
//		}
		int num = 1;
		String result = "";
		if (num==1) {
			result = "A";
		} else if(num == 2) {
			result = "B";
		} else if(num == 3) {
			result = "C";
		} else {
			result = "잘못 입력";
		}
	}

}
